package com.founderz.exception;

import com.founderz.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;

@Slf4j(topic = "#-Exception-Handler")
@RestControllerAdvice
class ExceptionController {
    @ExceptionHandler(FounderzException.class)
    EntityResponse<ErrorResponse> founderzException(final FounderzException e, final HttpServletRequest request) {
        final var errorResponse =  ErrorResponse.create(
                e.getStatusCode(),
                e.getMessage(),
                request.getRequestURI()
        );

        return EntityResponse.fromObject(errorResponse)
                .status(e.getStatusCode())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorResponse handleValidationExceptionHandler(final MethodArgumentNotValidException e, final HttpServletRequest request) {
        var errors = new HashMap<String, String>();

        e.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ErrorResponse.create(
                HttpStatus.BAD_REQUEST.value(),
                errors.toString(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponse handleAllExceptions(final Exception e, final HttpServletRequest request) {
        log.error(e.getMessage(), e.getLocalizedMessage());
        return ErrorResponse.create(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    ErrorResponse notSupportedException(final HttpRequestMethodNotSupportedException e, final HttpServletRequest request) {
        log.debug(e.getMessage(), e.getCause());
        return ErrorResponse.create(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                "허용되지 않은 메서드로 요청을 하셨습니다. 요청 내용을 다시 확인해주세요.",
                request.getRequestURI()
        );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse noHandlerFoundException(final NoHandlerFoundException e, final HttpServletRequest request) {
        log.debug(e.getMessage(), e.getCause());
        return ErrorResponse.create(
                HttpStatus.NOT_FOUND.value(),
                "존재하지 않는 API 엔드포인트로 요청을 하셨습니다. 요청 내용을 다시 확인해주세요.",
                request.getRequestURI()
        );
    }
}
