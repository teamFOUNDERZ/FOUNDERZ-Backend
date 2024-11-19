package com.founderz.userinterest.domain.persistence;

import com.founderz.internal.data.userinterest.UserInterestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface UserInterestDomainMapper {
    @Mapping(target = "id", source = ".", qualifiedByName = "createId")
    @Mapping(target = "cacheTagName", expression = "java(dto.tagName().tagName())")
    UserInterestEntity toEntity(UserInterestDto dto);

    @Named("createId")
    default UserInterestEntityId createId(UserInterestDto dto) {
        return new UserInterestEntityId(
                dto.userId().userId(),
                dto.tagId().tagId()
        );
    }

    @Mapping(target = "userId", expression = "java(UserId.create(entity.getId().userId()))")
    @Mapping(target = "tagId", expression = "java(TagId.create(entity.getId().tagId()))")
    @Mapping(target = "tagName", expression = "java(TagName.create(entity.getCacheTagName()))")
    UserInterestDto toDto(UserInterestEntity entity);

    default Optional<UserInterestDto> toOptionalDto(Optional<UserInterestEntity> entity) {
        return entity.map(this::toDto);
    }

    default List<UserInterestEntity> toEntityList(List<UserInterestDto> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .toList();
    }
}
