package com.founderz.auth.document;

import com.founderz.auth.presentation.LoginForm;
import com.founderz.auth.presentation.RegisterForm;
import com.founderz.common.vo.auth.PasetoToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "인증 쓰기 작업 API", description = "auth")
public interface AuthWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "회원가입을 성공하였습니다."
    )
    @Operation(summary = "회원가입 API")
    void register(RegisterForm form);

    @ApiResponse(
            responseCode = "200",
            description = "로그인을 성공하였습니다."
    )
    @Operation(summary = "로그인 API")
    PasetoToken login(LoginForm form);
}
