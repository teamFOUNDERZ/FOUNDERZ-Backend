package com.founderz.common.vo.user;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_ENG_N_NUM;

public record AccountId(
        @JsonValue
        String accountId
) implements ValueObject.StringValueObject {
    private static final Pattern ACCOUNT_ID_REGEX = Pattern.compile(ALLOWED_ONLY_ENG_N_NUM.getRegex(4, 20));

    public AccountId {
        assertArgumentNotEmpty(accountId, "계정의 아이디가 입력되지 않았습니다.");
        assertRegularExpression(accountId, ACCOUNT_ID_REGEX, "계정 아이디는 4~20자의 영문자와 숫자로만 구성되어야 합니다.");
    }

    public static AccountId create(final String accountId) {
        return new AccountId(accountId);
    }
}
