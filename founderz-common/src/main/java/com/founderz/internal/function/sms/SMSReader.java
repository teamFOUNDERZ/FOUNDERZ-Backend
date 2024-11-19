package com.founderz.internal.function.sms;

import com.founderz.common.vo.user.PhoneNumber;

public interface SMSReader {
    /**
     * 인증번호 발송 메서드
     *
     * @param tel 전화번호
     * @return 발송 여부
     */
    Boolean sendSMS(PhoneNumber tel);
}
