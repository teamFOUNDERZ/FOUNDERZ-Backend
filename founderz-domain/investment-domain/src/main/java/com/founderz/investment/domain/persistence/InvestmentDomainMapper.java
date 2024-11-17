package com.founderz.investment.domain.persistence;

import com.founderz.internal.data.investment.InvestmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface InvestmentDomainMapper {
    @Mapping(target = "id", expression = "java(dto.investmentId().investmentId())", ignore = true)
    @Mapping(target = "businessId", expression = "java(dto.businessId().businessId())")
    @Mapping(target = "investorAccountId", expression = "java(dto.investorAccountId().accountId())")
    @Mapping(target = "status", expression = "java(InvestmentEntity.Status.valueOf(dto.investmentStatus().status()))")
    @Mapping(target = "investmentAmount", expression = "java(dto.investmentAmount().investmentAmount())")
    @Mapping(target = "contact", expression = "java(dto.contact().contact())")
    @Mapping(target = "preferContractPeriod", expression = "java(dto.preferContractPeriod().date())")
    InvestmentEntity toEntity(InvestmentDto dto);

    @Mapping(target = "investmentId", expression = "java(InvestmentId.create(entity.getId()))")
    @Mapping(target = "businessId", expression = "java(BusinessId.create(entity.getBusinessId()))")
    @Mapping(target = "investorAccountId", expression = "java(AccountId.create(entity.getInvestorAccountId()))")
    @Mapping(target = "investmentStatus", expression = "java(InvestmentStatus.create(entity.getStatus().name()))")
    @Mapping(target = "investmentAmount", expression = "java(InvestmentAmount.create(entity.getInvestmentAmount()))")
    @Mapping(target = "contact", expression = "java(Contact.create(entity.getContact()))")
    @Mapping(target = "preferContractPeriod", expression = "java(PreferContractPeriod.create(entity.getPreferContractPeriod()))")
    InvestmentDto toDto(InvestmentEntity entity);
}