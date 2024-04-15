package com.rafaur.wastemicroservice.repository;

import com.rafaur.wastemicroservice.entity.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WasteManagerRepository extends
        JpaRepository<WasteManagerEntity, Long> {
}
