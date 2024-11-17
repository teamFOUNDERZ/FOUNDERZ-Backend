package com.founderz.notice.domain.persistence;

import com.founderz.internal.data.notice.NoticeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface NoticeDomainMapper {
    @Mapping(target = "noticeId", expression = "java(NoticeId.create(entity.getId()))")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "content", expression = "java(NoticeContent.create(entity.getContent()))")
    @Mapping(target = "userId", expression = "java(UserId.create(entity.getUserId()))")
    NoticeDto toDto(NoticeEntity entity);

    @Mapping(target = "id", expression = "java(dto.noticeId().noticeId())", ignore = true)
    @Mapping(target = "type", source = "type")
    @Mapping(target = "content", expression = "java(dto.content().content())")
    @Mapping(target = "userId", expression = "java(dto.userId().userId())")
    NoticeEntity toEntity(NoticeDto dto);

    default Optional<NoticeDto> toOptionalDto(Optional<NoticeEntity> entity) {
        return entity.map(this::toDto);
    }

    default List<NoticeDto> toListDto(List<NoticeEntity> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
