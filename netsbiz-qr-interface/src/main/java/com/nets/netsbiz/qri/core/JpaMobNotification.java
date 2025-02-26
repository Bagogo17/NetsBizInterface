package com.nets.netsbiz.qri.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mob_notification")
public class JpaMobNotification {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tid;
    private UUID sentToMobUserId;
    private LocalDateTime sendTime;
    private LocalDateTime receivedTime;
    private LocalDateTime openedTime;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;
    private String notificationType;
    private UUID qrTransactionId;
}
