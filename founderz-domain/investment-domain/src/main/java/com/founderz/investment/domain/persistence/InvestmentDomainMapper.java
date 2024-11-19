package com.founderz.investment.domain.persistence;

import com.founderz.internal.data.investment.InvestmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface InvestmentDomainMapper {
    @Mapping(target = "id", expression = "java(dto.investmentId().investmentId())", ignore = true)
    @Mapping(target = "businessId", expression = "java(dto.businessId().businessId())")
    @Mapping(target = "businessName", expression = "java(dto.businessName().name())")
    @Mapping(target = "investorAccountId", expression = "java(dto.investorAccountId().accountId())")
    @Mapping(target = "investorName", expression = "java(dto.investorName().name())")
    @Mapping(target = "investeeName", expression = "java(dto.investeeName().name())")
    @Mapping(target = "status", expression = "java(InvestmentEntity.Status.valueOf(dto.investmentStatus().status()))")
    @Mapping(target = "investmentAmount", expression = "java(dto.investmentAmount().investmentAmount())")
    @Mapping(target = "contact", expression = "java(dto.contact().contact())")
    @Mapping(target = "preferContractPeriod", expression = "java(dto.preferContractPeriod().date())")
    InvestmentEntity toEntity(InvestmentDto dto);

    @Mapping(target = "investmentId", expression = "java(InvestmentId.create(entity.getId()))")
    @Mapping(target = "businessId", expression = "java(BusinessId.create(entity.getBusinessId()))")
    @Mapping(target = "businessName", expression = "java(BusinessName.create(entity.getBusinessName()))")
    @Mapping(target = "investorAccountId", expression = "java(AccountId.create(entity.getInvestorAccountId()))")
    @Mapping(target = "investorName", expression = "java(AccountName.create(entity.getInvestorName()))")
    @Mapping(target = "investeeName", expression = "java(AccountName.create(entity.getInvesteeName()))")
    @Mapping(target = "investmentStatus", expression = "java(InvestmentStatus.create(entity.getStatus().name()))")
    @Mapping(target = "investmentAmount", expression = "java(InvestmentAmount.create(entity.getInvestmentAmount()))")
    @Mapping(target = "contact", expression = "java(Contact.create(entity.getContact()))")
    @Mapping(target = "preferContractPeriod", expression = "java(PreferContractPeriod.create(entity.getPreferContractPeriod()))")
    InvestmentDto toDto(InvestmentEntity entity);

    default Optional<InvestmentDto> toOptionalDto(Optional<InvestmentEntity> entity) {
        return entity.map(this::toDto);
    }
}