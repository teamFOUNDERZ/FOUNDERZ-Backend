package com.founderz.user.presentation.document;

import com.founderz.user.presentation.response.UserInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "사용자 읽기 작업 API", description = "user")
public interface UserReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "마이페이지 조회를 성공했습니다."
    )
    @Operation(summary = "마이페이지 조회 API")
    UserInfoResponse getUserInfo();
}