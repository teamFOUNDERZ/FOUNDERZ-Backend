package com.founderz.agreement.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface AgreementJpaRepository extends JpaRepository<AgreementEntity, Long> {
    Optional<AgreementEntity> findByInvestmentId(Long investmentId);
}
