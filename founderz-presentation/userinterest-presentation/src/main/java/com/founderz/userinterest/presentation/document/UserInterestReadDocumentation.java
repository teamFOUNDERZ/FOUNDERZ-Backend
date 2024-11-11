package com.founderz.userinterest.presentation.document;

import com.founderz.external.response.ListResponse;
import com.founderz.userinterest.presentation.response.UserInterestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "사용자 관심 읽기 작업 API", description = "user interest")
public interface UserInterestReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "현재 사용자의 관심사 조회를 성공했습니다."
    )
    @Operation(summary = "현재 사용자의 관심사 전체 조회 API")
    ListResponse<UserInterestResponse> getCurrentUserInterests();
}
