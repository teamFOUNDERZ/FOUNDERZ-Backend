package com.founderz.external.response;

import java.util.List;

public record ListResponse<V>(
        List<V> data,
        long numberOfData
) {
    public ListResponse(List<V> data) {
        this(data, data.size());
    }

    public static <T> ListResponse<T> create(List<T> data) {
        return new ListResponse<>(data);
    }
}
