package com.founderz.investment.presentation.document;

import com.founderz.investment.presentation.form.RequestInvestmentForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "투자 쓰기 작업 API", description = "investment")
public interface InvestmentWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "투자 요청을 성공하였습니다."
    )
    @Operation(summary = "투자 요청 API")
    void request(RequestInvestmentForm form);
}
