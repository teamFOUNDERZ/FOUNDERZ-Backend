package com.founderz.investment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

interface InvestmentJpaRepository extends JpaRepository<InvestmentEntity, Long> {
    List<InvestmentEntity> findAllByInvestorAccountId(String accountId);
    List<InvestmentEntity> findAllByStatusAndBusinessIdIn(InvestmentEntity.Status status, Collection<Long> businessId);
}
