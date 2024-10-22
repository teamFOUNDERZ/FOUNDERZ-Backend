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
        assertArgumentNotEmpty(accountId, "");
        assertArgumentNotEmpty(name, "");
        assertArgumentNotEmpty(type, "");
        assertArgumentNotEmpty(tel, "");
        assertArgumentNotEmpty(password, "");
    }
}
