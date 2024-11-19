package com.founderz.repayment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface RepaymentJpaRepository extends JpaRepository<RepaymentEntity, Long> {
}
