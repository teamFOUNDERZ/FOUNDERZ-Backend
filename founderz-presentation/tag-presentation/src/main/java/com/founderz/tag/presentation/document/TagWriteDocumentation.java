package com.founderz.tag.presentation.document;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.tag.presentation.form.TagCreateForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "태그 쓰기 작업 API", description = "tag")
public interface TagWriteDocumentation {
    @ApiResponse(
            responseCode = "204",
            description = "태그 생성을 완료했습니다."
    )
    @Operation(summary = "태그 생성 API (어드민)")
    void create(TagCreateForm form);

    @ApiResponse(
            responseCode = "200",
            description = "태그 삭제를 완료했습니다."
    )
    @Operation(summary = "태그 삭제 API (어드민)")
    void delete(SecuredTagId tagId);
}
