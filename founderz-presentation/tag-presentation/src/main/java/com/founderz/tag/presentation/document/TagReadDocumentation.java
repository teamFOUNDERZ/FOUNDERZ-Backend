package com.founderz.tag.presentation.document;

import com.founderz.tag.presentation.form.TagCreateForm;
import com.founderz.tag.presentation.response.TagResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "태그 읽기 작업 API", description = "tag")
public interface TagReadDocumentation {
    @ApiResponse(
            responseCode = "200",
            description = "태그 전체 조회를 성공했습니다."
    )
    @Operation(summary = "태그 전체 조회 API")
    List<TagResponse> getAll();
}
