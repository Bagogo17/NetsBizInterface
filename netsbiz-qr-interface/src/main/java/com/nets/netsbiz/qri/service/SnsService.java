package com.nets.netsbiz.qri.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nets.netsbiz.qri.core.SnsMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SnsService {

    final Logger log = LogManager.getLogger(SnsService.class);

    @Autowired
    SnsClient snsClient;
    @Autowired
    ObjectMapper objectMapper;

    public void publishMessage(SnsMessage snsMessage) {

        try {
            String messageJson = objectMapper.writeValueAsString(snsMessage.getMobNotification());
            String endPointArn = snsMessage.getTopicArn();
            log.info("[SNS] Publishing Message, TargetArn-{} , TerminalId-{}",endPointArn, snsMessage.getMobNotification().getTid());
            PublishRequest publishRequest = PublishRequest.builder()
                    .message(messageJson)
                    .targetArn(endPointArn).build();
            PublishResponse publish = snsClient.publish(publishRequest);
            log.info("Message Successfully Published -{}",publish.messageId());
        } catch (JsonProcessingException e) {

            throw new RuntimeException(e);
        }
    }
}
