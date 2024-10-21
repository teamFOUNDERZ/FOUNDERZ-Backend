package com.founderz.common.exception;

public class ServerException extends FounderzException {
    private static final int STATUS_CODE = 500;

    public ServerException() {
        super(STATUS_CODE);
    }

    public ServerException(final String message) {
        super(message, STATUS_CODE);
    }

    public ServerException(final Throwable throwable) {
        super(throwable, STATUS_CODE);
    }

    public ServerException(final String message, final Throwable throwable) {
        super(message, throwable, STATUS_CODE);
    }
}