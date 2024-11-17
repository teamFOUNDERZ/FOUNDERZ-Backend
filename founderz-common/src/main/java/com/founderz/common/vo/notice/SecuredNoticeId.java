package com.founderz.common.vo.notice;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

public record SecuredNoticeId(
        @JsonValue
        String noticeId
) implements ValueObject.StringValueObject {
    public static SecuredNoticeId create(final String noticeId) {
        return new SecuredNoticeId(noticeId);
    }

    public NoticeId toNoticeId() {
        return NoticeId.create(CryptoUtils.decrypt(noticeId));
    }
}
