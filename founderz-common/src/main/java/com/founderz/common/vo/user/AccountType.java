package com.founderz.common.vo.user;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;

public record AccountType(
        @JsonValue
        String type
) implements ValueObject.StringValueObject {
    private static final Pattern USER_ROLE_REGEX = Pattern.compile("^(PERSONAL|COMPANY|ADMIN)");

    public AccountType {
        assertArgumentNotEmpty(type, "계정의 유형이 입력되지 않았습니다.");
        assertRegularExpression(type, USER_ROLE_REGEX, "계정의 유형은 'PERSONAL','COMPANY', 'ADMIN' 이어야 합니다.");
    }

    public static AccountType create(final String type) {
        return new AccountType(type);
    }
}
