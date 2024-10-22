package com.founderz.auth.presentation;

import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_ENG_N_NUM;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR;
import static com.founderz.common.assertion.RegexUtils.TEL_REGEX;
import static com.founderz.common.assertion.RegexUtils.PASSWORD_REGEX;

record RegisterForm(
        String accountId,
        String name,
        String type,
        String tel,
        String password
) {
    RegisterForm {
        assertRegularExpression(accountId, ALLOWED_ONLY_ENG_N_NUM.getRegex(4, 20), "계정 아이디는 4~20자의 영문자와 숫자로만 구성되어야 합니다.");
        assertRegularExpression(name, ALLOWED_ONLY_KOR.getRegex(2, 6), "이름은 2~6자의 한글로 입력되어야 합니다.");
        assertRegularExpression(type, "^(PERSONAL|COMPANY)$", "계정의 유형은 'PERSONAL' 또는 'COMPANY'이어야 합니다.");
        assertRegularExpression(tel, TEL_REGEX.getRegex(), "전화번호 형식이 유효하지 않습니다. (예: 010-1234-5678)");
        assertRegularExpression(password, PASSWORD_REGEX.getRegex(8, 20), "비밀번호는 8~20자의 영문자, 숫자, 특수문자를 포함해야 합니다.");

        assertArgumentNotEmpty(accountId, "계정의 아이디가 입력되지 않았습니다.");
        assertArgumentNotEmpty(name, "이름이 입력되지 않았습니다.");
        assertArgumentNotEmpty(type, "계정의 유형이 입력되지 않았습니다.");
        assertArgumentNotEmpty(tel, "전화번호가 입력되지 않았습니다.");
        assertArgumentNotEmpty(password, "비밀번호가 입력되지 않았습니다.");
    }
}