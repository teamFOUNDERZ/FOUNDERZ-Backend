package com.founderz.security.current;

import com.founderz.common.security.CurrentUser;
import com.founderz.common.vo.user.UserId;
import com.founderz.user.domain.UserDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CurrentUserImpl implements CurrentUser {
    private final UserDomainReader userDomainReader;

    @Override
    public UserId get() {
        final var userId = SecurityContextHolder.getContext().getAuthentication().getName();

        return null;
    }
}
