package com.founderz.agreement.presentation.document;

import com.founderz.agreement.presentation.form.WriteAgreementForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "자금 투자 계약서 쓰기 작업 API", description = "agreement")
public interface AgreementWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "자금 투자 계약서 작성을 성공하였습니다."
    )
    @Operation(summary = "자금 투자 계약서 작성 API")
    void write(WriteAgreementForm form);
}