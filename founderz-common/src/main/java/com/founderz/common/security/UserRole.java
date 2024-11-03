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

    public static boolean contains(final String aType) {
        return Arrays.stream(UserRole.values())
                .anyMatch(t -> t.name().equals(aType));
    }

    UserRole(final String roleName) {
        this.roleName = roleName;
    }
}
