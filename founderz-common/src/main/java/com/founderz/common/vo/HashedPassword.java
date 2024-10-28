package com.founderz.common.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record HashedPassword(
        @JsonIgnore
        String password
) {
    public HashedPassword {
        assertArgumentNotEmpty(password, "비밀번호가 입력되지 않았습니다.");
    }
}
