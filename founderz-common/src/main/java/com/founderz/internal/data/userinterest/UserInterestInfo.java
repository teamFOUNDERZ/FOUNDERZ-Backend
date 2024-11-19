package com.founderz.internal.data.userinterest;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.tag.TagName;

public record UserInterestInfo(
        TagId tagId,
        TagName tagName
) {
    public static UserInterestInfo create(UserInterestDto dto) {
        return new UserInterestInfo(dto.tagId(), dto.tagName());
    }
}
