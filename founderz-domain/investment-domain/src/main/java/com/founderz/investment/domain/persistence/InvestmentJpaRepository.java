package com.founderz.investment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface InvestmentJpaRepository extends JpaRepository<InvestmentEntity, Long> {
    List<InvestmentEntity> findAllByInvestorAccountId(String accountId);
    List<InvestmentEntity> findAllByBusinessIdIn(List<Long> businessIds);
}
