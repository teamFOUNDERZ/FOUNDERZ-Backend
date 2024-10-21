package com.founderz.exception;

public class DataNotFoundException extends FounderzException {
    private static final int STATUS_CODE = 404;

    protected DataNotFoundException() {
        super(STATUS_CODE);
    }

    protected DataNotFoundException(final String message) {
        super(message, STATUS_CODE);
    }

    protected DataNotFoundException(final Throwable throwable) {
        super(throwable, STATUS_CODE);
    }

    protected DataNotFoundException(final String message, final Throwable throwable) {
        super(message, throwable, STATUS_CODE);
    }
}
