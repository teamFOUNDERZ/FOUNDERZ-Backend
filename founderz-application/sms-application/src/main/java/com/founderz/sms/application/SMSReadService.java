package com.founderz.sms.application;

import com.founderz.common.vo.user.PhoneNumber;

public interface SMSReadService {
    boolean send(PhoneNumber tel);
    boolean verifySms(PhoneNumber tel, String randomNumber);
}
