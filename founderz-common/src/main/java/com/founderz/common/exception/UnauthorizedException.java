package com.founderz.common.exception;

public class UnauthorizedException extends FounderzException {
    private static final int STATUS_CODE = 401;

    public UnauthorizedException() {
        super(STATUS_CODE);
    }

    public UnauthorizedException(final String message) {
        super(message, STATUS_CODE);
    }

    public UnauthorizedException(final Throwable throwable) {
        super(throwable, STATUS_CODE);
    }

    public UnauthorizedException(final String message, final Throwable throwable) {
        super(message, throwable, STATUS_CODE);
    }
}
