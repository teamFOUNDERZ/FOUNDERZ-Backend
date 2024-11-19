package com.founderz.agreement.presentation;

import com.founderz.agreement.presentation.form.AgreementForm;
import com.founderz.agreement.presentation.form.WriteAgreementForm;
import com.founderz.common.vo.areement.Address;
import com.founderz.common.vo.areement.AgreementId;
import com.founderz.common.vo.areement.DelinquentDamages;
import com.founderz.common.vo.areement.DelinquentQuarter;
import com.founderz.common.vo.areement.DepositDay;
import com.founderz.common.vo.areement.FinallyContractPeriod;
import com.founderz.common.vo.areement.Profit;
import com.founderz.common.vo.areement.RepaymentDelayDay;
import com.founderz.common.vo.areement.SignatureImageUrl;
import com.founderz.common.vo.areement.SpecialContractMatters;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.PreferContractPeriod;
import com.founderz.common.vo.user.AccountName;
import com.founderz.internal.data.agreement.AgreementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface WriteAgreementFormMapper {
    @Mapping(target = "agreementId", expression = "java(form.agreementId().toAgreementId())", ignore = true)
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
    AgreementDto toDto(AgreementForm form);
}
