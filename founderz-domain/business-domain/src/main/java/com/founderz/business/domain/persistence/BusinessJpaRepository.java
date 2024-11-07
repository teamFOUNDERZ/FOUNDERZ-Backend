package com.founderz.business.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface BusinessJpaRepository extends JpaRepository<BusinessEntity, Long> {
}
