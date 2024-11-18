package com.founderz.agreement.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface AgreementJpaRepository extends JpaRepository<AgreementEntity, Long> {
}
