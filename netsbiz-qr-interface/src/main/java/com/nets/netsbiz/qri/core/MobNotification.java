package com.nets.netsbiz.qri.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MobNotification {

    private String tid;
    private UUID sentToMobUserId;
    private LocalDateTime sentTime;
    private LocalDateTime receivedTime;
    private LocalDateTime openedTime;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;
    private String notificationType;
    private UUID qrTransactionId;

    public MobNotification(UUID qrTransactionId, UUID sentToMobUserId, String tid, String notificationType) {
        this.tid = tid;
        this.sentToMobUserId = sentToMobUserId;
        this.sentTime = LocalDateTime.now();
        this.createdDateTime = LocalDateTime.now();
        this.notificationType = notificationType;
        this.qrTransactionId = qrTransactionId;

    }
}
