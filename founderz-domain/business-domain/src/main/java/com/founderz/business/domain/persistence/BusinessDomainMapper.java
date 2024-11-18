package com.founderz.business.domain.persistence;

import com.founderz.internal.data.business.BusinessDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface BusinessDomainMapper {
    @Mapping(target = "id", expression = "java(dto.businessId().businessId())", ignore = true)
    @Mapping(target = "businessName", expression = "java(dto.businessName().name())")
    @Mapping(target = "oneLineIntroduction", expression = "java(dto.oneLineIntroduction().oneLineIntroduction())")
    @Mapping(target = "businessIntroduction", expression = "java(dto.businessIntroduction().businessIntroduction())")
    @Mapping(target = "vision", expression = "java(dto.vision().vision())")
    @Mapping(target = "writePurpose", expression = "java(dto.writePurpose().writePurpose())")
    @Mapping(target = "investmentAmount", expression = "java(dto.investmentAmount().investmentAmount())")
    @Mapping(target = "writerAccountId", expression = "java(dto.writerAccountId().accountId())")
    BusinessEntity toEntity(BusinessDto dto);

    @Mapping(target = "businessId", expression = "java(BusinessId.create(entity.getId()))")
    @Mapping(target = "businessName", expression = "java(BusinessName.create(entity.getBusinessName()))")
    @Mapping(target = "oneLineIntroduction", expression = "java(OneLineIntroduction.create(entity.getOneLineIntroduction()))")
    @Mapping(target = "businessIntroduction", expression = "java(BusinessIntroduction.create(entity.getBusinessIntroduction()))")
    @Mapping(target = "vision", expression = "java(Vision.create(entity.getVision()))")
    @Mapping(target = "writePurpose", expression = "java(WritePurpose.create(entity.getWritePurpose()))")
    @Mapping(target = "investmentAmount", expression = "java(InvestmentAmount.create(entity.getInvestmentAmount()))")
    @Mapping(target = "writerAccountId", expression = "java(AccountId.create(entity.getWriterAccountId()))")
    BusinessDto toDto(BusinessEntity entity);

    default Optional<BusinessDto> toOptionalDto(Optional<BusinessEntity> entity) {
        return entity.map(this::toDto);
    }
}
