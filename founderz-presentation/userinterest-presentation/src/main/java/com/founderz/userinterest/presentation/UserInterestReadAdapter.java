package com.founderz.userinterest.presentation;

import com.founderz.common.presentation.annotation.RequiredRoles;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.security.UserRole;
import com.founderz.external.response.ListResponse;
import com.founderz.userinterest.application.UserInterestReadService;
import com.founderz.userinterest.presentation.document.UserInterestReadDocumentation;
import com.founderz.userinterest.presentation.response.UserInterestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@WebRestAdapter("/api/users/interests")
class UserInterestReadAdapter implements UserInterestReadDocumentation {
    private final UserInterestReadService readService;

    @GetMapping
    @RequiredRoles({UserRole.PERSONAL})
    public ListResponse<UserInterestResponse> getCurrentUserInterests() {
        final var result = readService.getCurrentUserInterests().stream()
                .map(UserInterestResponse::create)
                .toList();

        return ListResponse.create(result);
    }
}
