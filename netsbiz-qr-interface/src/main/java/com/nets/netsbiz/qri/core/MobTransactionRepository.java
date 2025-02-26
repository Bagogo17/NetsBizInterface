package com.nets.netsbiz.qri.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MobTransactionRepository extends JpaRepository<JpaMobTransaction, UUID>, JpaSpecificationExecutor<JpaMobTransaction> {

    default UUID saveEntity(MobTransaction mobTransaction) {
        JpaMobTransaction entity = save(MobTransactionMapper.INSTANCE.domainToJpa(mobTransaction));
        return entity.getId();
    }

}
