package com.rafaur.wastemicroservice.repository;

import com.rafaur.wastemicroservice.entity.WasteCenterAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCenterAuthorizationRepository extends
        JpaRepository<WasteCenterAuthorizationEntity, Long> {
}
