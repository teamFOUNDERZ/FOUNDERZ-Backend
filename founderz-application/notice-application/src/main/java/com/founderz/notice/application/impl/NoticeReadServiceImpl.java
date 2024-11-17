package com.founderz.notice.application.impl;

import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.exception.ServerException;
import com.founderz.common.vo.notice.NoticeId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.notice.NoticeDto;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.notice.application.NoticeReadService;
import com.founderz.notice.domain.NoticeDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class NoticeReadServiceImpl implements NoticeReadService {
    private final CurrentUser currentUser;
    private final NoticeDomainReader reader;

    private final Map<UserId, SseEmitter> emitters = new ConcurrentHashMap<>();

    private static final long TIMEOUT = 60 * 60 * 60 * 1000L;

    @Override
    public NoticeDto getById(final NoticeId noticeId) {
        return reader.findById(noticeId)
                .orElseThrow(() -> new DataNotFoundException("알림을 찾지 못했습니다."));
    }

    @Override
    public List<NoticeDto> getAllByCurrentUser() {
        final var user = currentUser.get();
        return reader.findAllByUserId(user.userId());
    }

    @Override
    public SseEmitter subscribe() {
        final var userId = currentUser.get().userId();
        final var emitter = new SseEmitter(TIMEOUT);

        this.emitters.put(userId, emitter);

        emitter.onCompletion(() -> this.emitters.remove(userId));
        emitter.onTimeout(() -> this.emitters.remove(userId));

        try {
            emitter.send(SseEmitter.event()
                    .name("연결")
                    .data("연결성공.."));
        } catch (IOException e) {
            throw new ServerException("연결 중 오류 발생", e);
        }

        return emitter;
    }

    @Override
    public void sendNotification(NoticeDto noticeDto) {
        final var emitter = this.emitters.get(noticeDto.userId());
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event()
                        .name("notice")
                        .data(noticeDto));
            } catch (IOException e) {
                this.emitters.remove(noticeDto.userId());
                throw new ServerException("알림 전송 중 오류 발생....", e);
            }
        }
    }
}
