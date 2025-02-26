package com.nets.netsbiz.qri.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nets.netsbiz.qri.core.MobNotification;
import com.nets.netsbiz.qri.core.MobNotificationRepository;
import com.nets.netsbiz.qri.core.MobSnsPlatformRepository;
import com.nets.netsbiz.qri.core.MobTransaction;
import com.nets.netsbiz.qri.core.MobTransactionDto;
import com.nets.netsbiz.qri.core.MobTransactionDtoMapper;
import com.nets.netsbiz.qri.core.MobTransactionRepository;
import com.nets.netsbiz.qri.core.SnsMessage;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import software.amazon.awssdk.services.sqs.model.Message;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
@Transactional
@Retryable(value = Exception.class, maxAttemptsExpression = "${aws.sqs.retry.limit}")
public class ProcessMessageService {

    final Logger log = LogManager.getLogger(ProcessMessageService.class);

    @Autowired
    MobTransactionRepository mobTransactionRepository;
    @Autowired
    MobNotificationRepository mobNotificationRepository;
    @Autowired
    MobSnsPlatformRepository mobSnsPlatformRepository;
    @Autowired
    SnsService snsService;
    @Autowired
    RestTemplate restTemplate;

    public void processMessage(Message message) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MobTransactionDto mobTransactionDto = objectMapper.readValue(message.body(), MobTransactionDto.class);
            MobTransaction mobTransaction = MobTransactionDtoMapper.INSTANCE.dtoToDomain(mobTransactionDto);

            UUID mobTransactionId = mobTransactionRepository.saveEntity(mobTransaction);
            log.info("[SQS] Message successfully saved transactionId-{}", mobTransaction.getTransactionId());

            Map<UUID, String> endPointArnMap = mobSnsPlatformRepository.getEndPointForEachUserId(getListOfActiveUser());
            log.info("[SQS] EndPointArn Successfully Retrieved");

            for (UUID userId : endPointArnMap.keySet()) {
                String endPointAddress = endPointArnMap.get(userId);
                log.info("[SQS] Preparing Notification Payload, Topic-{}", endPointAddress);
                MobNotification mobNotification = new MobNotification(mobTransactionId, userId,
                        mobTransaction.getMobTerminalTid(), "PUSH");
                snsService.publishMessage(new SnsMessage(mobNotification, endPointAddress));
                mobNotificationRepository.saveEntity(mobNotification);
            }
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private List<UUID> getListOfActiveUser() {
        String url = "";
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UUID>>() {
                }).getBody();
    }
}
