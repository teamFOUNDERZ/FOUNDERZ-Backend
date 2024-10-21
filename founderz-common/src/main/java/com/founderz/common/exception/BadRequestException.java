package com.founderz.common.exception;

public class BadRequestException extends FounderzException {
    private static final int STATUS_CODE = 400;

    public BadRequestException() {
        super(STATUS_CODE);
    }

    public BadRequestException(final String message) {
        super(message, STATUS_CODE);
    }

    public BadRequestException(final Throwable throwable) {
        super(throwable, STATUS_CODE);
    }

    public BadRequestException(final String message, final Throwable throwable) {
        super(message, throwable, STATUS_CODE);
    }
}
