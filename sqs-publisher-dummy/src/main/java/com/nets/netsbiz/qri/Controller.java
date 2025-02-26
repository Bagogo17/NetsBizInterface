package com.nets.netsbiz.qri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    Repository repository;
    @Autowired
    SqsService sqsService;

    @GetMapping("/getActiveUsers")
    public List<UUID> getActiveUsers() {
        return repository.getUserIdBasesOnStatus("ACTIVE");
    }

    @PostMapping("/trigger")
    public void triggerSqsSendMessage(@RequestBody String messageJson) {
        sqsService.sendMessage(messageJson);
    }

}
