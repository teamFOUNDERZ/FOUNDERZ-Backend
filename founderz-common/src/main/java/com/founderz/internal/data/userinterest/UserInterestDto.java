package com.founderz.internal.data.userinterest;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.tag.TagName;
import com.founderz.common.vo.user.UserId;
import com.founderz.common.vo.userinterest.UserInterestId;

public record UserInterestDto(
        UserInterestId userInterestId,
        UserId userId,
        TagId tagId,
        TagName tagName
) {
}
