package com.founderz.common.exception;

public class DataNotFoundException extends FounderzException {
    private static final int STATUS_CODE = 404;

    public DataNotFoundException() {
        super(STATUS_CODE);
    }

    public DataNotFoundException(final String message) {
        super(message, STATUS_CODE);
    }

    public DataNotFoundException(final Throwable throwable) {
        super(throwable, STATUS_CODE);
    }

    public DataNotFoundException(final String message, final Throwable throwable) {
        super(message, throwable, STATUS_CODE);
    }
}
