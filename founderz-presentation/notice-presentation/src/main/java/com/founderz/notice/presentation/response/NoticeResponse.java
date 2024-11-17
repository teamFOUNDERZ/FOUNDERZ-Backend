package com.founderz.notice.presentation.response;

import com.founderz.common.vo.notice.NoticeContent;
import com.founderz.common.vo.notice.NoticeType;
import com.founderz.common.vo.notice.SecuredNoticeId;

public record NoticeResponse(
        SecuredNoticeId noticeId,
        NoticeResponseType type,
        NoticeContent content
) {
    public record NoticeResponseType(
            NoticeType type,
            String content
    ) {
        public NoticeResponseType(NoticeType type) {
            this(type, type.getContent());
        }

        public static NoticeResponseType create(NoticeType type) {
            return new NoticeResponseType(type);
        }
    }
}
