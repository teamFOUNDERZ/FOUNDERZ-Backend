package com.founderz.notice.presentation.response;

import com.founderz.common.vo.notice.NoticeContent;
import com.founderz.common.vo.notice.NoticeType;
import com.founderz.common.vo.notice.SecuredNoticeId;

public record NoticeResponse(
        SecuredNoticeId noticeId,
        NoticeType type,
        NoticeContent content
) {
}
