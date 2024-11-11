package com.founderz.userinterest.domain.persistence;

import com.founderz.internal.data.userinterest.UserInterestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

// UserInterestDto.java
//        UserInterestId userInterestId,
//        UserId userId,
//        TagId tagId,
//        TagName tagName
//
// UserInterestEntity.java
//        Long id,
//        Long userId,
//        Long tagId,
//        String cacheTagName
@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface UserInterestDomainMapper {
    @Mapping(target = "id", expression = "java(dto.userInterestId().userInterestId())", ignore = true)
    @Mapping(target = "userId", expression = "java(dto.userId().userId())")
    @Mapping(target = "tagId", expression = "java(dto.tagId().tagId())")
    @Mapping(target = "cacheTagName", expression = "java(dto.tagName().tagName())")
    UserInterestEntity toEntity(UserInterestDto dto);

    @Mapping(target = "userInterestId", expression = "java(UserInterestId.create(entity.getId()))")
    @Mapping(target = "userId", expression = "java(UserId.create(entity.getUserId()))")
    @Mapping(target = "tagId", expression = "java(TagId.create(entity.getTagId()))")
    @Mapping(target = "tagName", expression = "java(TagName.create(entity.getCacheTagName()))")
    UserInterestDto toDto(UserInterestEntity entity);
}
