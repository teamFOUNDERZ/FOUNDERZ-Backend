package com.founderz.notice.application;

import com.founderz.common.vo.notice.NoticeId;
import com.founderz.internal.data.notice.NoticeDto;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

public interface NoticeReadService {
    NoticeDto getById(NoticeId noticeId);
    List<NoticeDto> getAllByCurrentUser();

    SseEmitter subscribe();
    void sendNotification(NoticeDto noticeDto);
}
