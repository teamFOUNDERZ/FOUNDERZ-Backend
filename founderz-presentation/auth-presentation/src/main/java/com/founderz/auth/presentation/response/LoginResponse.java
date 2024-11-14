package com.founderz.auth.presentation.response;

import com.founderz.common.vo.auth.PasetoToken;

public record LoginResponse(
        PasetoToken token
) {
    public static LoginResponse create(final PasetoToken token) {
        return new LoginResponse(token);
    }
}
