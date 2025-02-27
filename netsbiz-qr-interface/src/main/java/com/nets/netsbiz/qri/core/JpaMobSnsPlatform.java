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
@Table(name = "mob_sns_platform_app")
public class JpaMobSnsPlatform {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID mobUserId;
    private String appEndpointArn;
    private String deviceToken;
    private String platform;
    private String appArn;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;
}
