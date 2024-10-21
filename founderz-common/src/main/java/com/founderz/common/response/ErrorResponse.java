package com.founderz.common.response;

import java.time.LocalDateTime;
import java.time.ZoneId;

public record ErrorResponse(
        int statusCode,
        String message,
        long timestamp,
        String path
) {
    private static final long TIMESTAMP = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

    public static ErrorResponse create(int status, String message, String path) {
        return new ErrorResponse(status, message, TIMESTAMP, path);
    }
}
