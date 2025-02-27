package com.nets.netsbiz.qri.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsMessageScheduler {

    @Autowired
    SqsService sqsService;

    @Scheduled(fixedRateString = "${aws.sqs.queueReadIntervalInMilliseconds}")
    public void pollingMessages() {
        log.info("Current Thread - {}", Thread.currentThread().getName());
        sqsService.onReceiveMessage();
    }
}
