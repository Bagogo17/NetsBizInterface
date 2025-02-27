package com.nets.netsbiz.qri.core;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MobTransactionDtoMapper {

    MobTransactionDtoMapper INSTANCE = Mappers.getMapper(MobTransactionDtoMapper.class);

    @Mapping(source = "hostMid", target = "mobTerminalRid")
    @Mapping(source = "hostTid", target = "mobTerminalTid")
    @Mapping(source = "transactionStatus", target = "status")
    MobTransaction dtoToDomain(MobTransactionDto dto);

    @Mapping(source = "mobTerminalRid", target = "hostMid")
    @Mapping(source = "mobTerminalTid", target = "hostTid")
    @Mapping(source = "status", target = "transactionStatus")
    MobTransactionDto domainToDto(MobTransaction domain);
}
