package com.nets.netsbiz.qri.core;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MobSnsPlatformRepository {

    @Autowired
    EntityManager entityManager;

    public Map<UUID, String> getEndPointForEachUserId(List<UUID> userIds) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MobSnsPlatformDto> criteriaQuery = criteriaBuilder.createQuery(MobSnsPlatformDto.class);
        Root<JpaMobSnsPlatform> root = criteriaQuery.from(JpaMobSnsPlatform.class);
        criteriaQuery.select(criteriaBuilder.construct(MobSnsPlatformDto.class ,
                root.get("mobUserId"), root.get("appEndpointArn")));
        TypedQuery<MobSnsPlatformDto> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList().stream().collect(Collectors.toMap(MobSnsPlatformDto::getMobUserId, MobSnsPlatformDto::getAppEndPointArn));
    }
}
