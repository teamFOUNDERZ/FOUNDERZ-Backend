package com.founderz.response;

import java.time.LocalDateTime;
import java.time.ZoneId;

public record ErrorResponse<T>(
        int statusCode,
        String message,
        T detail,
        long timestamp,
        String path
) {
    private static final long TIMESTAMP = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

    public static <T> ErrorResponse<T> create(int status, String message, String path) {
        return new ErrorResponse<>(status, message, null, TIMESTAMP, path);
    }
}
