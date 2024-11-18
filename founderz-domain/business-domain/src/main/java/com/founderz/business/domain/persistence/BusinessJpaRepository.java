package com.founderz.business.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface BusinessJpaRepository extends JpaRepository<BusinessEntity, Long> {
    List<BusinessEntity> findAllByWriterAccountId(String accountId);
}
