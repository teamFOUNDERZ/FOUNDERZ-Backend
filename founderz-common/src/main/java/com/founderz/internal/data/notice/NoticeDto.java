package com.founderz.internal.data.notice;

import com.founderz.common.vo.notice.NoticeContent;
import com.founderz.common.vo.notice.NoticeId;
import com.founderz.common.vo.notice.NoticeType;
import com.founderz.common.vo.user.UserId;

public record NoticeDto(
        NoticeId noticeId,
        NoticeContent content,
        NoticeType type,
        UserId userId
) {
    public static NoticeDto create(NoticeContent content, NoticeType type, UserId userId) {
        return new NoticeDto(null, content, type, userId);
    }
}
