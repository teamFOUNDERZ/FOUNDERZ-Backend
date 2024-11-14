package com.founderz.userinterest.presentation;

import com.founderz.internal.data.userinterest.UserInterestDto;
import com.founderz.userinterest.presentation.form.UserInterestAddForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface UserInterestFormMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "tagId", expression = "java(form.tagId().toTagId())")
    @Mapping(target = "tagName", ignore = true)
    UserInterestDto toDto(UserInterestAddForm form);
}
