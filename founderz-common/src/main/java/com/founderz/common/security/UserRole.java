package com.founderz.common.security;

import java.util.Arrays;

public enum UserRole {
    PERSONAL("ROLE_PERSONAL"),
    COMPANY("ROLE_COMPANY"),
    ADMIN("ROLE_ADMIN");

    private final String roleName;

    public String getRoleName() {
        return roleName;
    }

    UserRole(final String roleName) {
        this.roleName = roleName;
    }
}
