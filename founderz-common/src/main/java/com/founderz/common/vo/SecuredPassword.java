package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredPassword(
        @JsonIgnore
        String password
) implements ValueObject.StringValueObject {
    public SecuredPassword {
        assertArgumentNotEmpty(password, "비밀번호가 입력되지 않았습니다.");
    }

    public static SecuredPassword create(final String password) {
        return new SecuredPassword(password);
    }
}
