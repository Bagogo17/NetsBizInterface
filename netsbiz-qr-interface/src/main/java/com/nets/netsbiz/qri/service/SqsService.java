package com.nets.netsbiz.qri.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nets.netsbiz.qri.core.MobTransaction;
import com.nets.netsbiz.qri.core.MobTransactionDto;
import com.nets.netsbiz.qri.core.MobTransactionDtoMapper;
import com.nets.netsbiz.qri.core.MobTransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.services.sqs.model.ChangeMessageVisibilityRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.util.List;

@Service
public class SqsService {

    final Logger log = LogManager.getLogger(SqsService.class);

    @Autowired
    SqsClient sqsClient;
    @Autowired
    MobTransactionRepository mobTransactionRepository;
    @Autowired
    MobTransactionDtoMapper mapper;
    @Autowired
    ProcessMessageService processMessageService;

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.sqs.queueUrl}")
    private String queueUrl;

    @Value("${aws.sqs.visibility}")
    private int messageVisibility;

    //received message
    public void onReceiveMessage() {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .waitTimeSeconds(20)
                .visibilityTimeout(30)
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("[SQS] Message Retrieved From Queue -{}", messages.size());
        for (Message message : messages) {
            try {
                processMessageService.processMessage(message);
                deleteMessage(message);
            } catch (Exception e) {
                log.error("[SQS] Failed processing message after all retries", e);
                ChangeMessageVisibilityRequest visibilityRequest = ChangeMessageVisibilityRequest.builder()
                        .queueUrl(queueUrl)
                        .receiptHandle(message.receiptHandle())
                        .visibilityTimeout(messageVisibility)
                        .build();
                sqsClient.changeMessageVisibility(visibilityRequest);
                log.error("[SQS] Set Message Visibility to {}",messageVisibility);
            }
        }
    }

    private void deleteMessage(Message message) {
        DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                .queueUrl(queueUrl)
                .receiptHandle(message.receiptHandle())
                .build();
        sqsClient.deleteMessage(deleteMessageRequest);
    }
}
