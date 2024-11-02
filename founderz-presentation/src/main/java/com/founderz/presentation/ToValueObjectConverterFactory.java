package com.founderz.presentation;

import com.founderz.common.vo.ValueObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.NonNull;

class ToValueObjectConverterFactory implements ConverterFactory<String, ValueObject> {

    @Override
    public @NonNull <T extends ValueObject> Converter<String, T> getConverter(@NonNull Class<T> targetType) {
        return new ToValueObjectConverter<>(targetType);
    }

    private record ToValueObjectConverter<T extends ValueObject>(
            Class<T> targetType
    ) implements Converter<String, T> {
        @Override
        public T convert(@NonNull final String source) {
            try {
                if (ValueObject.StringValueObject.class.isAssignableFrom(targetType)) {
                    return targetType.getConstructor(String.class).newInstance(source);
                }

                if (ValueObject.LongValueObject.class.isAssignableFrom(targetType)) {
                    final var longValue = Long.parseLong(source);
                    return targetType.getConstructor(Long.class).newInstance(longValue);
                }

                throw new IllegalArgumentException("변환 실패. " + targetType.getSimpleName() + ";" + source.getClass().getSimpleName());
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

}
