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
    @Mapping(target = "investorName", expression = "java(dto.investorName().name())")
    @Mapping(target = "investmentAmount", expression = "java(dto.investmentAmount().investmentAmount())")
    @Mapping(target = "contact", expression = "java(dto.contact().contact())")
    @Mapping(target = "preferContractPeriod", expression = "java(dto.preferContractPeriod().date())")
    InvestmentEntity toEntity(InvestmentDto dto);

    @Mapping(target = "investmentId", expression = "java(InvestmentId.create(entity.getId()))")
    @Mapping(target = "businessId", expression = "java(SecuredBusinessId.create(entity.getBusinessId()))")
    @Mapping(target = "investorName", expression = "java(AccountName.create(entity.getInvestorName()))")
    @Mapping(target = "investmentAmount", expression = "java(InvestmentAmount.create(entity.getInvestmentAmount()))")
    @Mapping(target = "contact", expression = "java(Contact.create(entity.getContact()))")
    @Mapping(target = "preferContractPeriod", expression = "java(PreferContractPeriod.create(entity.getPreferContractPeriod()))")
    InvestmentDto toDto(InvestmentEntity entity);
}