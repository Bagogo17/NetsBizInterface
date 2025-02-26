package com.nets.netsbiz.qri.core;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-26T14:55:27+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Red Hat, Inc.)"
)
@Component
public class MobTransactionDtoMapperImpl implements MobTransactionDtoMapper {

    @Override
    public MobTransaction dtoToDomain(MobTransactionDto dto) {
        if ( dto == null ) {
            return null;
        }

        MobTransaction.MobTransactionBuilder mobTransaction = MobTransaction.builder();

        mobTransaction.mobTerminalRid( dto.getHostMid() );
        mobTransaction.mobTerminalTid( dto.getHostTid() );
        mobTransaction.status( dto.getTransactionStatus() );
        mobTransaction.stan( dto.getStan() );
        if ( dto.getAmount() != null ) {
            mobTransaction.amount( new BigDecimal( dto.getAmount() ) );
        }
        mobTransaction.currencyCode( dto.getCurrencyCode() );
        mobTransaction.paymentTypeId( dto.getPaymentTypeId() );
        mobTransaction.retrievalRef( dto.getRetrievalRef() );
        mobTransaction.transactionId( dto.getTransactionId() );
        mobTransaction.transactionDate( dto.getTransactionDate() );
        mobTransaction.transactionTime( dto.getTransactionTime() );

        return mobTransaction.build();
    }

    @Override
    public MobTransactionDto domainToDto(MobTransaction domain) {
        if ( domain == null ) {
            return null;
        }

        MobTransactionDto.MobTransactionDtoBuilder mobTransactionDto = MobTransactionDto.builder();

        mobTransactionDto.hostMid( domain.getMobTerminalRid() );
        mobTransactionDto.hostTid( domain.getMobTerminalTid() );
        mobTransactionDto.transactionStatus( domain.getStatus() );
        mobTransactionDto.retrievalRef( domain.getRetrievalRef() );
        if ( domain.getAmount() != null ) {
            mobTransactionDto.amount( domain.getAmount().toString() );
        }
        mobTransactionDto.stan( domain.getStan() );
        mobTransactionDto.transactionTime( domain.getTransactionTime() );
        mobTransactionDto.transactionDate( domain.getTransactionDate() );
        mobTransactionDto.currencyCode( domain.getCurrencyCode() );
        mobTransactionDto.paymentTypeId( domain.getPaymentTypeId() );
        mobTransactionDto.transactionId( domain.getTransactionId() );

        return mobTransactionDto.build();
    }
}
