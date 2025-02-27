package com.nets.netsbiz.qri.core;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MobNotificationMapper {

    MobNotificationMapper INSTANCE = Mappers.getMapper(MobNotificationMapper.class);

    MobNotification jpaToDomain(JpaMobNotification jpaMobNotification);

    JpaMobNotification domainToJpa(MobNotification mobNotification);
}
