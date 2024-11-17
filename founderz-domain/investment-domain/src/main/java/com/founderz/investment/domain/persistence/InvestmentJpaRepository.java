package com.founderz.investment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentJpaRepository extends JpaRepository<InvestmentEntity, Long> {
}
