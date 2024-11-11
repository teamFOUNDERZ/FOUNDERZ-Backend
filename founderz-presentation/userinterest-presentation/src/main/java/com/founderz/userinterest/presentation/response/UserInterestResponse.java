package com.founderz.userinterest.presentation.response;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.tag.TagName;
import com.founderz.internal.data.userinterest.UserInterestDto;

public record UserInterestResponse(
        SecuredTagId tagId,
        TagName tagName
) {
    public static UserInterestResponse create(UserInterestDto dto) {
        return new UserInterestResponse(dto.tagId().toSecureTagId(), dto.tagName());
    }
}
