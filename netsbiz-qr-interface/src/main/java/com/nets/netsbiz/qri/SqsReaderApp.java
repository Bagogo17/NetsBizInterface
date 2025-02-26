package com.nets.netsbiz.qri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableRetry
public class SqsReaderApp {
    public static void main(String[] args) {
        SpringApplication.run(SqsReaderApp.class, args);
    }
}