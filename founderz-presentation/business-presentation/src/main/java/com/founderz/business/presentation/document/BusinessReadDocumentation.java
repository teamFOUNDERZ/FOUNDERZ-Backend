package com.founderz.business.presentation.document;

import com.founderz.business.presentation.response.BusinessDetails;
import com.founderz.business.presentation.response.BusinessListResponse;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.external.response.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "사업 아이템 읽기 작업 API", description = "business")
public interface BusinessReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "사업 아이템 전체 조회를 성공했습니다."
    )
    @Operation(summary = "사업 아이템 전체 조회 API")
    ListResponse<BusinessListResponse> getAll();

    @ApiResponse(
            responseCode = "200",
            description = "사업 아이템 상세 조회를 성공했습니다."
    )
    @Operation(summary = "사업 아이템 상세 조회 API")
    BusinessDetails getById(SecuredBusinessId businessId);
}
