package com.founderz.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.founderz.assertion.AssertionUtils.*;

@RestController
@RequestMapping("/api/auth")
class RegisterController {
    @PostMapping("/register")
    Object register(
            @RequestBody RegisterForm form
    ) {
        return null;
    }
}

record RegisterForm(
        String accountId,
        String name,
        String type,
        String tel,
        String password
) {
    RegisterForm {
        assertRegularExpression(accountId, "^[a-zA-Z0-9]{4,20}$", "계정 아이디는 4~20자의 영문자와 숫자로만 구성되어야 합니다.");
        assertRegularExpression(name, "^[a-zA-Z가-힣 ]{2, 11}$", "이름은 한글 또는 영문으로 입력되어야 합니다.");
        assertRegularExpression(type, "^(PERSONAL|COMPANY)$", "계정의 유형은 'PERSONAL' 또는 'COMPANY'이어야 합니다.");
        assertRegularExpression(tel, "^01(?:0|1|[6-9])-(\\d{3,4})-(\\d{4})$", "전화번호 형식이 유효하지 않습니다. (예: 010-1234-5678)");
        assertRegularExpression(password, "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{8,20}$", "비밀번호는 8~20자의 영문자, 숫자, 특수문자를 포함해야 합니다.");

        assertArgumentNotEmpty(accountId, "계정의 아이디가 입력되지 않았습니다.");
        assertArgumentNotEmpty(name, "이름이 입력되지 않았습니다.");
        assertArgumentNotEmpty(type, "계정의 유형이 입력되지 않았습니다.");
        assertArgumentNotEmpty(tel, "전화번호가 입력되지 않았습니다.");
        assertArgumentNotEmpty(password, "비밀번호가 입력되지 않았습니다.");
    }
}
