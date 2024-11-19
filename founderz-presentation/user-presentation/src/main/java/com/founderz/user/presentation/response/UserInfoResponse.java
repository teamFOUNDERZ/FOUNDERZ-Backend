package com.founderz.user.presentation.response;

import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.AccountName;
import com.founderz.common.vo.user.AccountType;
import com.founderz.common.vo.user.MyMoney;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.external.response.userintersest.InterestResponse;
import com.founderz.internal.data.user.CurrentUserInfo;
import com.founderz.internal.data.userinterest.UserInterestInfo;

import java.util.List;

public record UserInfoResponse(
        AccountId accountId,
        AccountName name,
        MyMoney myMoney,
        AccountType accountType,
        PhoneNumber phoneNumber,
        List<InterestResponse> tags
) {
    public static UserInfoResponse create(CurrentUserInfo userInfo, List<UserInterestInfo> interests) {
        return new UserInfoResponse(userInfo.accountId(), userInfo.name(), userInfo.myMoney(),
                userInfo.type(), userInfo.phoneNumber(), interests.stream().map(InterestResponse::create).toList());
    }
}
