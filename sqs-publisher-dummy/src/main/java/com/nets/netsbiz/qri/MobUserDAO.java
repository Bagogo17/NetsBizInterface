package com.nets.netsbiz.qri;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface MobUserDAO extends JpaRepository<JpaMobUser, UUID>, JpaSpecificationExecutor<JpaMobUser> {

    List<JpaMobUser> findByStatus(String status);
}
