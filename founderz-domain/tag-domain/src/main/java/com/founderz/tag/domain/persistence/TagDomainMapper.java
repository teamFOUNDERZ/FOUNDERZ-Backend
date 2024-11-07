package com.founderz.tag.domain.persistence;

import com.founderz.tag.domain.dto.TagDomainDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface TagDomainMapper {
    @Mapping(target = "id", expression = "java(TagEntityId.create(dto.id(),dto.name()))")
    TagEntity toEntity(TagDomainDto dto);

    @Mapping(target = "id", expression = "java(TagId.create(entity.getId().id()))")
    @Mapping(target = "name", expression = "java(TagName.create(entity.getId().name()))")
    TagDomainDto toDto(TagEntity entity);

    default Optional<TagDomainDto> toOptionalDto(Optional<TagEntity> entity) {
        return entity.map(this::toDto);
    }
}
