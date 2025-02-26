package com.nets.netsbiz.qri.core;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-26T14:55:26+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Red Hat, Inc.)"
)
@Component
public class MobTransactionMapperImpl implements MobTransactionMapper {

    @Override
    public MobTransaction jpaToDomain(JpaMobTransaction jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        MobTransaction.MobTransactionBuilder mobTransaction = MobTransaction.builder();

        mobTransaction.mobTerminalRid( jpaEntity.getMobTerminalRid() );
        mobTransaction.mobTerminalTid( jpaEntity.getMobTerminalTid() );
        mobTransaction.stan( jpaEntity.getStan() );
        mobTransaction.iconRef( jpaEntity.getIconRef() );
        mobTransaction.amount( jpaEntity.getAmount() );
        mobTransaction.currencyCode( jpaEntity.getCurrencyCode() );
        mobTransaction.paymentTypeId( jpaEntity.getPaymentTypeId() );
        mobTransaction.retrievalRef( jpaEntity.getRetrievalRef() );
        mobTransaction.transactionId( jpaEntity.getTransactionId() );
        mobTransaction.transactionDate( jpaEntity.getTransactionDate() );
        mobTransaction.transactionTime( jpaEntity.getTransactionTime() );
        mobTransaction.status( jpaEntity.getStatus() );

        return mobTransaction.build();
    }

    @Override
    public JpaMobTransaction domainToJpa(MobTransaction domain) {
        if ( domain == null ) {
            return null;
        }

        JpaMobTransaction jpaMobTransaction = new JpaMobTransaction();

        jpaMobTransaction.setMobTerminalRid( domain.getMobTerminalRid() );
        jpaMobTransaction.setMobTerminalTid( domain.getMobTerminalTid() );
        jpaMobTransaction.setStan( domain.getStan() );
        jpaMobTransaction.setIconRef( domain.getIconRef() );
        jpaMobTransaction.setAmount( domain.getAmount() );
        jpaMobTransaction.setCurrencyCode( domain.getCurrencyCode() );
        jpaMobTransaction.setPaymentTypeId( domain.getPaymentTypeId() );
        jpaMobTransaction.setRetrievalRef( domain.getRetrievalRef() );
        jpaMobTransaction.setTransactionId( domain.getTransactionId() );
        jpaMobTransaction.setTransactionDate( domain.getTransactionDate() );
        jpaMobTransaction.setTransactionTime( domain.getTransactionTime() );
        jpaMobTransaction.setStatus( domain.getStatus() );

        return jpaMobTransaction;
    }
}
