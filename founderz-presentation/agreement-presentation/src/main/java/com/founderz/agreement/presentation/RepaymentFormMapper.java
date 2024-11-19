package com.founderz.agreement.presentation;

import com.founderz.agreement.presentation.form.RepaymentForm;
import com.founderz.internal.data.repayment.RepaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface RepaymentFormMapper {
    @Mapping(target = "repaymentId", ignore = true)
    @Mapping(target = "investmentId", expression = "java(form.investmentId().toInvestmentId())")
    @Mapping(target = "repaymentAmount", source = "repaymentAmount")
    @Mapping(target = "repaymentDate", source = "repaymentDate")
    RepaymentDto toDto(RepaymentForm form);
}
