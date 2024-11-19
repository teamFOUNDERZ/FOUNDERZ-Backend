package com.founderz.external.response.userintersest;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.tag.TagName;
import com.founderz.internal.data.userinterest.UserInterestInfo;

public record InterestResponse(
        SecuredTagId tagId,
        TagName tagName
) {
    public static InterestResponse create(UserInterestInfo dto) {
        return new InterestResponse(dto.tagId().toSecureTagId(), dto.tagName());
    }
}
