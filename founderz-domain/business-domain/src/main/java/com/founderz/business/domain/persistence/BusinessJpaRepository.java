package com.founderz.business.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessJpaRepository extends JpaRepository<BusinessEntity, Long> {
}
