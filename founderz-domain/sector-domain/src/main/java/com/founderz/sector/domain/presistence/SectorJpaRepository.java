package com.founderz.sector.domain.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SectorJpaRepository extends JpaRepository<SectorEntity, SectorEntityId> {
    List<SectorEntity> findAllById_BusinessId(Long businessId);
}
