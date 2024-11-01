package com.founderz.presentation;

import com.founderz.common.vo.ValueObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.NonNull;

class StringToValueObjectConverterFactory implements ConverterFactory<String, ValueObject> {

    @Override
    public @NonNull <T extends ValueObject> Converter<String, T> getConverter(@NonNull Class<T> targetType) {
        return new StringToValueObjectConverter<>(targetType);
    }

    private record StringToValueObjectConverter<T extends ValueObject>(
            Class<T> targetType) implements Converter<String, T> {

        @Override
            public T convert(@NonNull final String source) {
                try {
                    return targetType.getConstructor(String.class).newInstance(source);
                } catch (Exception e) {
                    throw new IllegalArgumentException("변환 실패. " + targetType.getSimpleName(), e);
                }
            }
        }

}
