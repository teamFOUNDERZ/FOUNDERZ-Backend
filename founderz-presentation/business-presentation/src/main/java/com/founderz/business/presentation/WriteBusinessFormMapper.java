package com.founderz.business.presentation;

import com.founderz.business.presentation.form.WriteBusinessForm;
import com.founderz.internal.data.business.BusinessDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface WriteBusinessFormMapper {
    @Mapping(target = "businessId", ignore = true)
    @Mapping(target = "businessName", source = "businessName")
    @Mapping(target = "oneLineIntroduction", source = "oneLineIntroduction")
    @Mapping(target = "businessIntroduction", source = "businessIntroduction")
    @Mapping(target = "vision", source = "vision")
    @Mapping(target = "writePurpose", source = "writePurpose")
    @Mapping(target = "investmentAmount", ignore = true)
    @Mapping(target = "writerAccountId", ignore = true)
    BusinessDto toDto(WriteBusinessForm form);
}