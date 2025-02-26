package com.nets.netsbiz.qri.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnsMessage {

    private MobNotification mobNotification;
    private String topicArn;

    public SnsMessage(MobNotification mobNotification, String topicArn) {
        this.mobNotification = mobNotification;
        this.topicArn = topicArn;
    }
}
