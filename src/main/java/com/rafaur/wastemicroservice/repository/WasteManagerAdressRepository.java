package com.rafaur.wastemicroservice.repository;

import com.rafaur.wastemicroservice.entity.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerAdressRepository extends
        JpaRepository<WasteManagerAddressEntity, Long > {
}
