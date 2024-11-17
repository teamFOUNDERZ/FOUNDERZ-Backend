package com.founderz.notice.presentation;

import com.founderz.internal.data.notice.NoticeDto;
import com.founderz.notice.presentation.response.NoticeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface NoticeResponseMapper {
    @Mapping(target = "noticeId", expression = "java(dto.noticeId().toSecureNoticeId())")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "type", source = "type")
    NoticeResponse toResponse(NoticeDto dto);

    default List<NoticeResponse> toListResponse(List<NoticeDto> dtoList) {
        return dtoList.stream().map(this::toResponse).toList();
    }
}
