package com.founderz.investment.presentation.document;

import com.founderz.external.response.ListResponse;
import com.founderz.investment.presentation.response.InvestmentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "투자 읽기 작업 API", description = "investment")
public interface InvestmentReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "받은 투자 요청 조회를 성공했습니다."
    )
    @Operation(summary = "받은 투자 요청 조회 API")
    ListResponse<InvestmentResponse> getReceivedInvestmentRequest();

    @ApiResponse(
            responseCode = "200",
            description = "내 투자 요청 조회를 성공했습니다."
    )
    @Operation(summary = "내 투자 요청 조회 API")
    ListResponse<InvestmentResponse> getMyInvestment();
}
