package com.nets.netsbiz.qri.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MobNotificationRepository extends JpaRepository<JpaMobNotification, UUID> , JpaSpecificationExecutor<JpaMobNotification> {

    default void saveEntity(MobNotification mobNotification) {
        save(MobNotificationMapper.INSTANCE.domainToJpa(mobNotification));
    }
}
