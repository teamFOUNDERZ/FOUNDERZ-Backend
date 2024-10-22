package com.founderz.common.assertion;

public enum RegexUtils {
    // 010-1234-1234
    TEL_REGEX("^01(?:0|1|[6-9])-(\\d{3,4})-(\\d{4})$"),
    // 8~20자의 영문자, 숫자, 특수문자를 포함
    PASSWORD_REGEX("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]"),

    ALLOWED_ONLY_KOR("^[가-힣]"),
    ALLOWED_ONLY_ENG("^[a-zA-Z]"),
    ALLOWED_ONLY_KOR_N_ENG("^[a-zA-Z가-힣]"),
    ALLOWED_ONLY_ENG_N_NUM("^[a-zA-Z0-9]");

    private final String regex;

    public String getRegex() {
        if (!this.equals(TEL_REGEX)) {
            throw new IllegalStateException("올바르지 않은 객체에서 `getRegex()`를 호출했습니다.");
        }
        return regex;
    }

    public String getRegex(final int minLength, final int maxLength) {
        if (this.equals(TEL_REGEX)) {
            return regex;
        }
        return regex + "{" + minLength + "," + maxLength + "}" + "$";
    }

    RegexUtils(final String regex) {
        this.regex = regex;
    }
}
