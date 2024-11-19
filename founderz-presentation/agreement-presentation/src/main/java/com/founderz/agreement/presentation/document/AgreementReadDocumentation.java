package com.founderz.agreement.presentation.document;

import com.founderz.agreement.presentation.response.AgreementDetails;
import com.founderz.common.vo.investment.SecuredInvestmentId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "자금 투자 계약서 읽기 작업 API", description = "agreement")
public interface AgreementReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "자금투자 계약서 조회를 성공했습니다."
    )
    @Operation(summary = "자금 투자 계약서 조회 API")
    AgreementDetails getByInvestmentId(SecuredInvestmentId investmentId);
}
