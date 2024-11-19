package com.founderz.internal.data.user;

import com.founderz.internal.data.userinterest.UserInterestDto;
import com.founderz.internal.data.userinterest.UserInterestInfo;

import java.util.List;

public record UserWithInterestsDto(
        CurrentUserInfo userInfo,
        List<UserInterestInfo> interests
) {
    public static UserWithInterestsDto create(CurrentUserInfo userInfo, List<UserInterestDto> dtos) {
        return new UserWithInterestsDto(userInfo, dtos.stream().map(UserInterestInfo::create).toList());
    }
}
