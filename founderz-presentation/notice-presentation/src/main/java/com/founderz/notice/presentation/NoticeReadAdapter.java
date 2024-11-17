package com.founderz.notice.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.vo.notice.SecuredNoticeId;
import com.founderz.external.response.ListResponse;
import com.founderz.notice.application.NoticeReadService;
import com.founderz.notice.presentation.document.NoticeReadDocumentation;
import com.founderz.notice.presentation.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequiredArgsConstructor
@WebRestAdapter("/api/notices")
class NoticeReadAdapter implements NoticeReadDocumentation {
    private final NoticeReadService readService;
    private final NoticeResponseMapper mapper;

    @GetMapping("/{noticeId}")
    public NoticeResponse getById(@PathVariable SecuredNoticeId noticeId) {
        final var dto = readService.getById(noticeId.toNoticeId());
        return mapper.toResponse(dto);
    }

    @GetMapping
    public ListResponse<NoticeResponse> getAllByCurrentUser() {
        final var dtoList = readService.getAllByCurrentUser();
        final var responseList = mapper.toListResponse(dtoList);

        return ListResponse.create(responseList);
    }

    @GetMapping(path = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe() {
        return readService.subscribe();
    }
}
