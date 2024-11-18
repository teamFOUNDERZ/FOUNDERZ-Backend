package com.founderz.internal.data.userinterest;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.tag.TagName;
import com.founderz.common.vo.user.UserId;

public record UserInterestDto(
        UserId userId,
        TagId tagId,
        TagName tagName
) {
    public static UserInterestDto create(UserId userId, TagId tagId, TagName tagName) {
        return new UserInterestDto(userId, tagId, tagName);
    }

    public UserInterestDto setTagNameAndUserId(final UserId userId, final TagName tagName) {
        return new UserInterestDto(userId, tagId, tagName);
    }

    public UserInterestDto setUserId(final UserId userId) {
        return new UserInterestDto(userId, tagId, tagName);
    }

    public UserInterestDto setTagName(final TagName tagName) {
        return new UserInterestDto(userId, tagId, tagName);
    }
}
