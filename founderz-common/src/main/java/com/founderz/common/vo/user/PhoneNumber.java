package com.founderz.common.vo.user;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;
import com.founderz.common.vo.auth.AccountIdentifier;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.TEL;

public record PhoneNumber(
        @JsonValue
        String phoneNumber
) implements ValueObject.StringValueObject {
    private static final Pattern TEL_NUMBER_REGEX = Pattern.compile(TEL.getRegex());

    public PhoneNumber {
        assertArgumentNotEmpty(phoneNumber, "전화번호가 입력되지 않았습니다.");
        assertRegularExpression(phoneNumber, TEL_NUMBER_REGEX, "전화번호 형식이 유효하지 않습니다. (예: 01012345678)");
    }

    public static PhoneNumber create(final String phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }

    public static boolean isTelNumber(final AccountIdentifier identifier) {
        return TEL_NUMBER_REGEX.matcher(identifier.identifier()).matches();
    }
}
