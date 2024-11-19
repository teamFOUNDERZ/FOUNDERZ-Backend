package com.founderz.agreement.domain.persistence;

import com.founderz.internal.data.agreement.AgreementDto;
import com.founderz.internal.data.business.BusinessDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface AgreementDomainMapper {
    @Mapping(target = "id", expression = "java(dto.agreementId().agreementId())", ignore = true)
    @Mapping(target = "investmentId", expression = "java(dto.investmentId().investmentId())")
    @Mapping(target = "investorName", expression = "java(dto.investorName().name())")
    @Mapping(target = "investeeName", expression = "java(dto.investeeName().name())")
    @Mapping(target = "investmentAmount", expression = "java(dto.investmentAmount().investmentAmount())")
    @Mapping(target = "preferContractPeriod", expression = "java(dto.preferContractPeriod().date())")
    @Mapping(target = "finallyContractPeriod", expression = "java(dto.finallyContractPeriod().date())")
    @Mapping(target = "profit", expression = "java(dto.profit().profit())")
    @Mapping(target = "depositDay", expression = "java(dto.depositDay().day())")
    @Mapping(target = "repaymentDelayDay", expression = "java(dto.repaymentDelayDay().day())")
    @Mapping(target = "delinquentQuarter", expression = "java(dto.delinquentQuarter().quarter())")
    @Mapping(target = "delinquentDamages", expression = "java(dto.delinquentDamages().damages())")
    @Mapping(target = "specialContractMatters", expression = "java(dto.specialContractMatters().stream().map(SpecialContractMatters::content).toList())")
    @Mapping(target = "address", expression = "java(dto.address().address())")
    @Mapping(target = "representativeName", expression = "java(dto.representativeName().name())")
    @Mapping(target = "contact", expression = "java(dto.contact().contact())")
    @Mapping(target = "signatureImageUrl", expression = "java(dto.signatureImageUrl().url())")
    AgreementEntity toEntity(AgreementDto dto);

    @Mapping(target = "agreementId", expression = "java(AgreementId.create(entity.getId()))")
    @Mapping(target = "investmentId", expression = "java(InvestmentId.create(entity.getInvestmentId()))")
    @Mapping(target = "investorName", expression = "java(AccountName.create(entity.getInvestorName()))")
    @Mapping(target = "investeeName", expression = "java(AccountName.create(entity.getInvesteeName()))")
    @Mapping(target = "investmentAmount", expression = "java(InvestmentAmount.create(entity.getInvestmentAmount()))")
    @Mapping(target = "preferContractPeriod", expression = "java(PreferContractPeriod.create(entity.getPreferContractPeriod()))")
    @Mapping(target = "finallyContractPeriod", expression = "java(FinallyContractPeriod.create(entity.getFinallyContractPeriod()))")
    @Mapping(target = "profit", expression = "java(Profit.create(entity.getProfit()))")
    @Mapping(target = "depositDay", expression = "java(DepositDay.create(entity.getDepositDay()))")
    @Mapping(target = "repaymentDelayDay", expression = "java(RepaymentDelayDay.create(entity.getRepaymentDelayDay()))")
    @Mapping(target = "delinquentQuarter", expression = "java(DelinquentQuarter.create(entity.getDelinquentQuarter()))")
    @Mapping(target = "delinquentDamages", expression = "java(DelinquentDamages.create(entity.getDelinquentDamages()))")
    @Mapping(target = "specialContractMatters", expression = "java(entity.getSpecialContractMatters().stream().map(SpecialContractMatters::create).toList())")
    @Mapping(target = "address", expression = "java(Address.create(entity.getAddress()))")
    @Mapping(target = "representativeName", expression = "java(AccountName.create(entity.getRepresentativeName()))")
    @Mapping(target = "contact", expression = "java(Contact.create(entity.getContact()))")
    @Mapping(target = "signatureImageUrl", expression = "java(SignatureImageUrl.create(entity.getSignatureImageUrl()))")
    AgreementDto toDto(AgreementEntity entity);

    default Optional<AgreementDto> toOptionalDto(Optional<AgreementEntity> entity) {
        return entity.map(this::toDto);
    }
}