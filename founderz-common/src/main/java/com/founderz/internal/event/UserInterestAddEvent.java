package com.founderz.internal.event;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.user.UserId;

import java.util.List;

public record UserInterestAddEvent(
        List<TagId> tagIds,
        UserId userId
) {
    public static UserInterestAddEvent create(List<SecuredTagId> tagIds, UserId userId) {
        return new UserInterestAddEvent(
                tagIds.stream()
                        .map(SecuredTagId::toTagId)
                        .toList(),
                userId
        );
    }
}
