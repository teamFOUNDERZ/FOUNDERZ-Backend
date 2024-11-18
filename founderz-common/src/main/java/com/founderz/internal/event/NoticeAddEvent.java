package com.founderz.internal.event;

import com.founderz.common.vo.notice.NoticeContent;
import com.founderz.common.vo.notice.NoticeType;
import com.founderz.common.vo.user.UserId;

public record NoticeAddEvent(
        NoticeType noticeType,
        UserId targetUserId,
        NoticeContent noticeContent
) {
    public static NoticeAddEvent create(NoticeType noticeType, UserId targetUserId, NoticeContent noticeContent) {
        return new NoticeAddEvent(
                noticeType,
                targetUserId,
                noticeContent
        );
    }
}
