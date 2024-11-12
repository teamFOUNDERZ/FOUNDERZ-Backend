package com.founderz.sector.presentation.document;

import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.external.response.ListResponse;
import com.founderz.sector.presentation.response.SectorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "사업 아이템 분야 읽기 API", description = "sector")
public interface SectorReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "해당 사업 아이템의 분야 목록 조회를 성공했습니다."
    )
    @Operation(summary = "사업 아이템의 분야 목록 조회 API")
    ListResponse<SectorResponse> getBusinessSectors(SecuredBusinessId businessId);
}
