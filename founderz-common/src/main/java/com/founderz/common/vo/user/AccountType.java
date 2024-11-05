package com.founderz.common.vo.user;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.exception.BadRequestException;
import com.founderz.common.security.UserRole;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record AccountType(
        @JsonValue
        String type
) implements ValueObject.StringValueObject {
    public AccountType {
        assertArgumentNotEmpty(type, "계정의 유형이 입력되지 않았습니다.");

        if (!UserRole.contains(type)) {
            throw new BadRequestException("계정의 유형은 'PERSONAL','COMPANY', 'ADMIN' 이어야 합니다.");
        }
    }

    public static AccountType create(final String type) {
        return new AccountType(type);
    }
}
