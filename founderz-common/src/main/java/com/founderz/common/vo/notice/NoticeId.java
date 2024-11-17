package com.founderz.common.vo.notice;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

public record NoticeId(
        @JsonValue
        Long noticeId
) implements ValueObject.LongValueObject {
    public static NoticeId create(final Long noticeId) {
        return new NoticeId(noticeId);
    }

    public SecuredNoticeId toSecureNoticeId() {
        return SecuredNoticeId.create(CryptoUtils.encrypt(noticeId));
    }
}
