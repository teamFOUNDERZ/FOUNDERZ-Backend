package com.founderz.auth.document;

import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.PhoneNumber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "인증 읽기 작업 API", description = "auth")
public interface AuthReadDocumentation {
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "사용할 수 있는 전화번호입니다."
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "사용할 수 없는, 이미 존재하는 전화번호입니다."
            )
    })
    @Operation(summary = "전화번호 검증 API")
    ResponseEntity<Void> validateTelNumber(PhoneNumber phoneNumber);

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "사용할 수 있는 계정 아이디입니다."
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "사용할 수 없는, 이미 존재하는 계정 아이디입니다."
            )
    })
    @Operation(summary = "계정 아이디 검증 API")
    ResponseEntity<Void> validateAccountId(AccountId accountId);
}
