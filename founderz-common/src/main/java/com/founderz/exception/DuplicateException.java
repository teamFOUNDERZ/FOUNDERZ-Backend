package com.founderz.exception;

public class DuplicateException extends FounderzException {
    private static final int STATUS_CODE = 400;

    public DuplicateException() {
        super(STATUS_CODE);
    }

    public DuplicateException(final String message) {
        super(message, STATUS_CODE);
    }

    public DuplicateException(final Throwable throwable) {
        super(throwable, STATUS_CODE);
    }

    public DuplicateException(final String message, final Throwable throwable) {
        super(message, throwable, STATUS_CODE);
    }
}
