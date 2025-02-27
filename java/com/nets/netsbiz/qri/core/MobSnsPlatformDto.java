package com.nets.netsbiz.qri.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MobSnsPlatformDto {

    private UUID mobUserId;
    private String appEndPointArn;
}
