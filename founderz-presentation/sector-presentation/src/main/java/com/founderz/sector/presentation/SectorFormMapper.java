package com.founderz.sector.presentation;

import com.founderz.internal.data.sector.SectorDto;
import com.founderz.sector.presentation.form.SectorAddForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface SectorFormMapper {
    @Mapping(target = "businessId", ignore = true)
    @Mapping(target = "tagId", expression = "java(form.tagId().toTagId())")
    @Mapping(target = "tagName", ignore = true)
    SectorDto toDto(SectorAddForm form);
}
