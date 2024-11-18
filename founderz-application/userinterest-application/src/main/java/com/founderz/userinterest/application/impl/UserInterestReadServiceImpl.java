package com.founderz.userinterest.application.impl;

import com.founderz.internal.data.userinterest.UserInterestDto;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.userinterest.application.UserInterestReadService;
import com.founderz.userinterest.domain.UserInterestDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class UserInterestReadServiceImpl implements UserInterestReadService {
    private final UserInterestDomainReader reader;
    private final CurrentUser currentUser;

    @Override
    public List<UserInterestDto> getCurrentUserInterests() {
        final var user = currentUser.get();
        return reader.findAllByUserId(user.userId());
    }
}
