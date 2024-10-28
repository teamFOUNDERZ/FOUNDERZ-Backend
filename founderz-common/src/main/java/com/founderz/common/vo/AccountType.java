package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.exception.BadRequestException;

import java.util.Arrays;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record AccountType(
        @JsonValue
        String type
) {
    public AccountType {
        assertArgumentNotEmpty(type, "계정의 유형이 입력되지 않았습니다.");

        if (!Type.contains(type)) {
            throw new BadRequestException("계정의 유형은 'PERSONAL' 또는 'COMPANY'이어야 합니다.");
        }
    }

    private enum Type {
        PERSONAL,
        COMPANY;

        static boolean contains(String aType) {
            return Arrays.stream(Type.values())
                    .anyMatch(t -> t.name().equals(aType));
        }
    }
}
