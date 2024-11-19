package com.founderz.repayment.domain.persistence;

import com.founderz.internal.data.repayment.RepaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface RepaymentDomainMapper {
    @Mapping(target = "id", expression = "java(dto.repaymentId().repaymentId())", ignore = true)
    @Mapping(target = "investmentId", expression = "java(dto.investmentId().investmentId())")
    @Mapping(target = "repaymentAmount", expression = "java(dto.repaymentAmount().repaymentAmount())")
    @Mapping(target = "repaymentDate", expression = "java(dto.repaymentDate().date())")
    RepaymentEntity toEntity(RepaymentDto dto);

    @Mapping(target = "repaymentId", expression = "java(RepaymentId.create(entity.getId()))")
    @Mapping(target = "investmentId", expression = "java(InvestmentId.create(entity.getInvestmentId()))")
    @Mapping(target = "repaymentAmount", expression = "java(RepaymentAmount.create(entity.getRepaymentAmount()))")
    @Mapping(target = "repaymentDate", expression = "java(RepaymentDate.create(entity.getRepaymentDate()))")
    RepaymentDto toDto(RepaymentEntity entity);
}