package com.founderz.investment.presentation;

import com.founderz.internal.data.investment.InvestmentDto;
import com.founderz.investment.presentation.form.RequestInvestmentForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface RequestInvestmentFormMapper {
    @Mapping(target = "investmentId", ignore = true)
    @Mapping(target = "businessId", expression = "java(form.businessId().toBusinessId())")
    @Mapping(target = "businessName", ignore = true)
    @Mapping(target = "investorAccountId", ignore = true)
    @Mapping(target = "investorName", ignore = true)
    @Mapping(target = "investeeName", ignore = true)
    @Mapping(target = "investmentStatus", ignore = true)
    @Mapping(target = "investmentAmount", source = "investmentAmount")
    @Mapping(target = "contact", source = "contact")
    @Mapping(target = "preferContractPeriod", source = "preferContractPeriod")
    InvestmentDto toDto(RequestInvestmentForm form);
}