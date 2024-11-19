package com.founderz.user.application.impl;

import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.user.UserDto;
import com.founderz.internal.data.user.UserWithInterestsDto;
import com.founderz.internal.function.Interest.InterestReader;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.user.application.UserReadService;
import com.founderz.user.domain.UserDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
class UserReadServiceImpl implements UserReadService {
    private final UserDomainReader userDomainReader;
    private final InterestReader interestReader;
    private final CurrentUser currentUser;

    @Override
    public UserDto getByAccountId(AccountId accountId) {
        return userDomainReader.findByAccountId(accountId)
                .orElseThrow(() -> new DataNotFoundException("사용자를 찾지 못했습니다."));
    }

    @Override
    public UserWithInterestsDto getCurrentUserInfo() {
        final var user = currentUser.get();
        final var interests = interestReader.findAllByUserId(user.userId());

        return UserWithInterestsDto.create(user, interests);
    }
}
