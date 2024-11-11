package com.founderz.userinterest.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.external.response.ListResponse;
import com.founderz.userinterest.application.UserInterestReadService;
import com.founderz.userinterest.presentation.response.UserInterestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@WebRestAdapter("/api/users/interests")
class UserInterestReadAdapter {
    private final UserInterestReadService readService;

    @GetMapping
    public ListResponse<UserInterestResponse> getCurrentUserInterests() {
        final var result = readService.getCurrentUserInterests().stream()
                .map(UserInterestResponse::create)
                .toList();

        return ListResponse.create(result);
    }
}
