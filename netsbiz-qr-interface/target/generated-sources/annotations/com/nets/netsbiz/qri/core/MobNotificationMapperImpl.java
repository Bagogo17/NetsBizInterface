package com.nets.netsbiz.qri.core;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-26T14:55:26+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Red Hat, Inc.)"
)
@Component
public class MobNotificationMapperImpl implements MobNotificationMapper {

    @Override
    public MobNotification jpaToDomain(JpaMobNotification jpaMobNotification) {
        if ( jpaMobNotification == null ) {
            return null;
        }

        MobNotification.MobNotificationBuilder mobNotification = MobNotification.builder();

        mobNotification.tid( jpaMobNotification.getTid() );
        mobNotification.sentToMobUserId( jpaMobNotification.getSentToMobUserId() );
        mobNotification.receivedTime( jpaMobNotification.getReceivedTime() );
        mobNotification.openedTime( jpaMobNotification.getOpenedTime() );
        mobNotification.createdDateTime( jpaMobNotification.getCreatedDateTime() );
        mobNotification.modifiedDateTime( jpaMobNotification.getModifiedDateTime() );
        mobNotification.notificationType( jpaMobNotification.getNotificationType() );
        mobNotification.qrTransactionId( jpaMobNotification.getQrTransactionId() );

        return mobNotification.build();
    }

    @Override
    public JpaMobNotification domainToJpa(MobNotification mobNotification) {
        if ( mobNotification == null ) {
            return null;
        }

        JpaMobNotification jpaMobNotification = new JpaMobNotification();

        jpaMobNotification.setTid( mobNotification.getTid() );
        jpaMobNotification.setSentToMobUserId( mobNotification.getSentToMobUserId() );
        jpaMobNotification.setReceivedTime( mobNotification.getReceivedTime() );
        jpaMobNotification.setOpenedTime( mobNotification.getOpenedTime() );
        jpaMobNotification.setCreatedDateTime( mobNotification.getCreatedDateTime() );
        jpaMobNotification.setModifiedDateTime( mobNotification.getModifiedDateTime() );
        jpaMobNotification.setNotificationType( mobNotification.getNotificationType() );
        jpaMobNotification.setQrTransactionId( mobNotification.getQrTransactionId() );

        return jpaMobNotification;
    }
}
