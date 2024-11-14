package com.founderz.common.vo.auth;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.user.AccountType;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;

public record RegisterType(
        @JsonValue
        String type
) {
    private static final Pattern REGISTER_TYPE_REGEX = Pattern.compile("^(PERSONAL|COMPANY)$");

    public RegisterType {
        assertArgumentNotEmpty(type, "계정 유형이 입력되지 않았습니다.");
        assertRegularExpression(type, REGISTER_TYPE_REGEX, "계정 유형은 'PERSONAL' 또는 'COMPANY' 이어야 합니다.");
    }

    public AccountType toAccountType() {
        return AccountType.create(type);
    }
}
