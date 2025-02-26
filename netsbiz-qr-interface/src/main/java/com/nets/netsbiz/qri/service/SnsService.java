package com.nets.netsbiz.qri.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nets.netsbiz.qri.core.SnsMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SnsService {

    final Logger log = LogManager.getLogger(SnsService.class);

    @Autowired
    SnsClient snsClient;

    public void publishMessage(SnsMessage snsMessage) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String messageJson = objectMapper.writeValueAsString(snsMessage.getMobNotification());
            String endPointArn = snsMessage.getTopicArn();
            log.info("[SNS] Publishing Message, Topic-{} , TerminalId-{}",endPointArn, snsMessage.getMobNotification().getTid());
            PublishRequest publishRequest = PublishRequest.builder()
                    .message(messageJson)
                    .topicArn(endPointArn).build();
            snsClient.publish(publishRequest);
        } catch (JsonProcessingException e) {

            throw new RuntimeException(e);
        }
    }
}
