package com.founderz.notice.event;

import com.founderz.internal.data.notice.NoticeDto;
import com.founderz.internal.event.NoticeAddEvent;
import com.founderz.notice.application.NoticeWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
class NoticeAddEventHandler {
    private final NoticeWriteService noticeWriteService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(NoticeAddEvent noticeAddEvent) {
        noticeWriteService.save(NoticeDto.create(
                noticeAddEvent.noticeContent(),
                noticeAddEvent.noticeType(),
                noticeAddEvent.targetUserId()
        ));
    }
}
