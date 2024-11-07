package com.founderz.business.domain.persistence;

import com.founderz.business.domain.dto.BusinessDomainDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface BusinessDomainMapper {
    @Mapping(target = "id", expression = "java(dto.id().businessId())", ignore = true)
    @Mapping(target = "businessName", expression = "java(dto.businessName().name())")
    @Mapping(target = "oneLineIntroduction", expression = "java(dto.oneLinerIntroduction().oneLinerIntroduction())")
    @Mapping(target = "businessIntroduction", expression = "java(dto.businessIntroduction().businessIntroduction())")
    @Mapping(target = "vision", expression = "java(dto.vision().vision())")
    @Mapping(target = "writePurpose", expression = "java(dto.writePurpose().writePurpose())")
    @Mapping(target = "investmentAmount", expression = "java(dto.investmentAmount().investmentAmount())")
    @Mapping(target = "writerAccountId", expression = "java(dto.writerAccountId().accountId())")
    BusinessEntity toEntity(BusinessDomainDto dto);

    @Mapping(target = "id", expression = "java(BusinessId.create(entity.id()))")
    @Mapping(target = "businessName", expression = "java(BusinessName.create(entity.businessName()))")
    @Mapping(target = "oneLineIntroduction", expression = "java(OneLineIntroduction.create(entity.oneLineIntroduction()))")
    @Mapping(target = "businessIntroduction", expression = "java(BusinessIntroduction.create(entity.businessIntroduction()))")
    @Mapping(target = "vision", expression = "java(Vision.create(entity.vision()))")
    @Mapping(target = "writePurpose", expression = "java(WritePurpose.create(entity.writePurpose()))")
    @Mapping(target = "investmentAmount", expression = "java(InvestmentAmount.create(entity.investmentAmount()))")
    @Mapping(target = "writerAccountId", expression = "java(WriterAccountId.create(entity.writerAccountId()))")
    BusinessDomainDto toDto(BusinessEntity entity);

    default Optional<BusinessDomainDto> toOptionalDto(Optional<BusinessEntity> entity) {
        return entity.map(this::toDto);
    }
}
