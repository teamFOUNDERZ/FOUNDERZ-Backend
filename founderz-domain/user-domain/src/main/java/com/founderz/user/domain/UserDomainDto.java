package com.founderz.user.domain;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record UserDomainDto(
        Long id,
        String accountId,
        String name,
        String type,
        String tel,
        String password
) {
    public UserDomainDto {
        assertArgumentNotEmpty(accountId, "계정의 아이디가 존재하지 않습니다.");
        assertArgumentNotEmpty(name, "계정의 이름이 존재하지 않습니다.");
        assertArgumentNotEmpty(type, "계정의 유형이 존재하지 않습니다.");
        assertArgumentNotEmpty(tel, "계정의 전화번호가 존재하지 않습니다.");
        assertArgumentNotEmpty(password, "계정의 비밀번호가 존재하지 않습니다.");
    }
}
