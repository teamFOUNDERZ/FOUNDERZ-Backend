package com.founderz.repayment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface RepaymentJpaRepository extends JpaRepository<RepaymentEntity, Long> {
    List<RepaymentEntity> findAllByInvestmentId(Long investmentId);
}
