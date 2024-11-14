package com.founderz.userinterest.presentation.document;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.userinterest.presentation.form.UserInterestAddForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "사용 관심사 쓰기 작업 API", description = "user interest")
public interface UserInterestWriteDocumentation {
    @ApiResponse(
            responseCode = "201",
            description = "관심사 등록에 성공했습니다."
    )
    @Operation(summary = "사용자 관심사 등록 API")
    void addUserInterest(UserInterestAddForm form);

    @ApiResponse(
            responseCode = "204",
            description = "관심사 삭제에 성공했습니다."
    )
    @Operation(summary = "사용자 관심사 삭제 API")
    void removeUserInterest(SecuredTagId tagId);
}
