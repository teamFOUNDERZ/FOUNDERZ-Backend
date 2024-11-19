package com.founderz.user.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.user.application.UserReadService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@WebRestAdapter("/api/users")
class UserReadAdapter {
    private final UserReadService readService;

    public
}
