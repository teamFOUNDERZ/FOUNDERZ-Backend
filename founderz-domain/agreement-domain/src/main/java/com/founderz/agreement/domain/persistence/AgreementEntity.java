package com.founderz.agreement.domain.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "founderz_agreement_v1")
class AgreementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long investmentId;

    @Column(nullable = false, unique = true, length = 6)
    private String investorName;

    @Column(nullable = false, length = 6)
    private String investeeName;

    @Column(nullable = false)
    private Long investmentAmount;

    @Column(nullable = false)
    private LocalDate preferContractPeriod;

    @Column(nullable = false)
    private LocalDate finallyContractPeriod;

    @Column(nullable = false)
    private float profit;

    @Column(nullable = false)
    private Integer depositDay;

    @Column(nullable = false)
    private Integer repaymentDelayDay;

    @Column(nullable = false)
    private Integer delinquentQuarter;

    @Column(nullable = false)
    private Integer delinquentDamages;

    @ElementCollection
    @Column(nullable = false)
    private List<String> specialContractMatters;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 6)
    private String exponentName;

    @Column(nullable = false, length = 30)
    private String contact;

    @Column(nullable = false, length = 50)
    private String signatureImageUrl;
}