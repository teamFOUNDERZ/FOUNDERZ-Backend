package com.founderz.common.exception;

public class FounderzException extends RuntimeException {
    private final int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    protected FounderzException(final int statusCode) {
        this.statusCode = statusCode;
    }

    protected FounderzException(final String message, final int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    protected FounderzException(final Throwable throwable, final int statusCode) {
        super(throwable);
        this.statusCode = statusCode;
    }

    protected FounderzException(final String message, final Throwable throwable, final int statusCode) {
        super(message, throwable);
        this.statusCode = statusCode;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
