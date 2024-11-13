package com.founderz.business.presentation.document;

import com.founderz.business.presentation.form.WriteBusinessForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "사업 아이템 쓰기 작업 API", description = "business")
public interface BusinessWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "사업 아이템 작성을 성공하였습니다."
    )
    @Operation(summary = "사업 아이템 작성 API")
    void write(WriteBusinessForm form);
}
