package com.founderz.tag.presentation;

import com.founderz.internal.data.tag.TagDto;
import com.founderz.tag.presentation.form.TagCreateForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface TagFormMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    TagDto toDto(TagCreateForm form);
}
