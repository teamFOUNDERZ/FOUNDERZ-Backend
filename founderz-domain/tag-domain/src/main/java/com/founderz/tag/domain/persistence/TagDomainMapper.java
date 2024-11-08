package com.founderz.tag.domain.persistence;

import com.founderz.internal.data.tag.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface TagDomainMapper {
    @Mapping(target = "id", expression = "java(TagEntityId.create(dto.id().tagId(),dto.name().tagName()))")
    TagEntity toEntity(TagDto dto);

    @Mapping(target = "id", expression = "java(TagId.create(entity.getId().id()))")
    @Mapping(target = "name", expression = "java(TagName.create(entity.getId().name()))")
    TagDto toDto(TagEntity entity);

    default Optional<TagDto> toOptionalDto(Optional<TagEntity> entity) {
        return entity.map(this::toDto);
    }
}
