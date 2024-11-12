package com.founderz.sector.presentation.document;

import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.sector.presentation.form.SectorAddForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "사업 아이템 분야 쓰기 API", description = "sector")
public interface SectorWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "사업 아이템 분야 등록에 성공했습니다."
    )
    @Operation(summary = "사업 아이템 분야 등록 API")
    void addSector(SectorAddForm form, SecuredBusinessId businessId);

    @ApiResponse(
            responseCode = "204",
            description = "사업 아이템 분야 삭제에 성공했습니다."
    )
    @Operation(summary = "사업 아이템 분야 삭제 API")
    void removeSector(SecuredBusinessId businessId, SecuredTagId tagId);
}
