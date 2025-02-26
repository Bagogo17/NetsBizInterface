package com.nets.netsbiz.qri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SqsMessageScheduler {

    @Autowired
    SqsService sqsService;

    @Scheduled(fixedRateString = "${aws.sqs.queueReadIntervalInMilliseconds}")
    public void pollingMessages() {
        sqsService.onReceiveMessage();
    }
}
