package com.founderz.presentation.converter;

import com.founderz.common.exception.BadRequestException;
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
            if (ValueObject.StringValueObject.class.isAssignableFrom(targetType)) {
                try {
                    return targetType.getConstructor(String.class).newInstance(source);
                } catch (Exception e) {
                    handleMismatchTypeException(e);
                }
            }

            if (ValueObject.LongValueObject.class.isAssignableFrom(targetType)) {
                final var longValue = Long.parseLong(source);
                try {
                    return targetType.getConstructor(Long.class).newInstance(longValue);
                } catch (Exception e) {
                    handleMismatchTypeException(e);
                }
            }
            throw new BadRequestException("변환 실패. " + targetType.getSimpleName() + ";" + source.getClass().getSimpleName());
        }

        private static void handleMismatchTypeException(final Exception e) {
            final var cause = e.getCause();
            if (cause instanceof BadRequestException exception) {
                throw exception;
            }
            throw new IllegalArgumentException("입력값 변환 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

}
