package com.nets.netsbiz.qri.core;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MobTransactionMapper {

    MobTransactionMapper INSTANCE = Mappers.getMapper(MobTransactionMapper.class);

    MobTransaction jpaToDomain(JpaMobTransaction jpaEntity);

    JpaMobTransaction domainToJpa(MobTransaction domain);

}
