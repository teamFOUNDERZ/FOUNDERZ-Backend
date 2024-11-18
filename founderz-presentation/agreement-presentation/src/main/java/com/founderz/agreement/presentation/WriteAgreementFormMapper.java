package com.founderz.agreement.presentation;

import com.founderz.agreement.presentation.form.WriteAgreementForm;
import com.founderz.internal.data.agreement.AgreementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface WriteAgreementFormMapper {
    @Mapping(target = "agreementId", ignore = true)
    @Mapping(target = "investmentId", expression = "java(form.investmentId().toInvestmentId())")
    @Mapping(target = "investorName", source = "investorName")
    @Mapping(target = "investeeName", source = "investeeName")
    @Mapping(target = "investmentAmount", source = "investmentAmount")
    @Mapping(target = "preferContractPeriod", source = "preferContractPeriod")
    @Mapping(target = "finallyContractPeriod", source = "finallyContractPeriod")
    @Mapping(target = "profit", source = "profit")
    @Mapping(target = "depositDay", source = "depositDay")
    @Mapping(target = "repaymentDelayDay", source = "repaymentDelayDay")
    @Mapping(target = "delinquentQuarter", source = "delinquentQuarter")
    @Mapping(target = "delinquentDamages", source = "delinquentDamages")
    @Mapping(target = "specialContractMatters", source = "specialContractMatters")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "representativeName", source = "representativeName")
    @Mapping(target = "contact", source = "contact")
    @Mapping(target = "signatureImageUrl", source = "signatureImageUrl")
    AgreementDto toDto(WriteAgreementForm form);
}