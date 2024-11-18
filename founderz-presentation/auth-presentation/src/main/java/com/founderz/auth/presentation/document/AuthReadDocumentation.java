package com.founderz.auth.presentation.document;

import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.PhoneNumber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "인증 읽기 작업 API", description = "auth")
public interface AuthReadDocumentation {
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

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "인증번호가 발송에 성공했습니다."
            ),
    })

    @Operation(summary = "인증번호 발송 API")
    ResponseEntity<Void> sendSMS(PhoneNumber phoneNumber);

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "유효한 인증번호입니다."
            ),
    })

    @Operation(summary = "인증번호 검증 API")
    ResponseEntity<Void> isVerify(PhoneNumber phoneNumber, String randomNum) ;
}
