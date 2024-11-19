package com.founderz.investment.domain.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "founderz_investment_v1")
class InvestmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long businessId;

    @Column(nullable = false, length = 20)
    private String businessName;

    @Column(nullable = false, length = 20)
    private String investorAccountId;

    @Column(nullable = false, length = 6)
    private String investorName;

    @Column(nullable = false, length = 6)
    private String investeeName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Long investmentAmount;

    @Column(nullable = false, length = 30)
    private String contact;

    @Column(nullable = false)
    private LocalDate preferContractPeriod;

    enum Status {
        WRITING,
        COMPLETE,
        REJECTED,
        CONCLUDED
    }
}
