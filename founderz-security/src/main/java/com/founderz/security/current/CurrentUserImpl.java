package com.founderz.security.current;

import com.founderz.common.exception.UnauthorizedException;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.user.CurrentUserInfo;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.user.domain.UserDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class CurrentUserImpl implements CurrentUser {
    private final UserDomainReader userDomainReader;
    private final CurrentUserMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public CurrentUserInfo get() {
        final var accountId = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        final var userDto = userDomainReader.findByAccountId(AccountId.create(accountId))
                .orElseThrow(() -> new UnauthorizedException("인증에 실패하였습니다."));

        return mapper.toCurrentUserInfo(userDto);
    }
}
