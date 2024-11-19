package com.founderz.security.entrypoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.founderz.common.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Primary
@Component
@RequiredArgsConstructor
class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    private static final int NOT_FOUND_VALUE = NOT_FOUND.value();
    private static final String ERROR_MESSAGE = "잘못된 요청입니다.";

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        
        final var errorBody = ErrorResponse.create(
                NOT_FOUND_VALUE,
                ERROR_MESSAGE,
                request.getRequestURI()
        );

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(errorBody));
    }
}