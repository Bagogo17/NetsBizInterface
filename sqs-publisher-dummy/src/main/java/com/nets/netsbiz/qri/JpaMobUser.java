package com.nets.netsbiz.qri;

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
@Table(name = "mob_user")
public class JpaMobUser {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String mobileNumber;
    private String name;
    private int lock;
    private int loginRetry;
    private Long createdBy;
    private Long approvedBy;
    private LocalDateTime approvedDatetime;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String status;
}
