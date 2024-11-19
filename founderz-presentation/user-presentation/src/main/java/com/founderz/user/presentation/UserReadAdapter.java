package com.founderz.user.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.user.application.UserReadService;
import com.founderz.user.presentation.document.UserReadDocumentation;
import com.founderz.user.presentation.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@WebRestAdapter("/api/users")
class UserReadAdapter implements UserReadDocumentation {
    private final UserReadService readService;

    @GetMapping("/my-info")
    public UserInfoResponse getUserInfo() {
        final var userWithInterestsDto = readService.getCurrentUserInfo();

        return UserInfoResponse.create(userWithInterestsDto.userInfo(), userWithInterestsDto.interests());
    }
}
