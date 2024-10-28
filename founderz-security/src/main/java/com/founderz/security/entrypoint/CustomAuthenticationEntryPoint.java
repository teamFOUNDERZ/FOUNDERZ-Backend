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

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Primary
@Component
@RequiredArgsConstructor
class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    private static final int FORBIDDEN_VALUE = FORBIDDEN.value();
    private static final String ERROR_MESSAGE = "Access Denied: 접근할 수 없습니다.";

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
        response.setStatus(FORBIDDEN_VALUE);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        
        final var errorBody = ErrorResponse.create(
                FORBIDDEN_VALUE,
                ERROR_MESSAGE,
                request.getRequestURI()
        );
        
        objectMapper.writeValue(response.getWriter(), errorBody);
    }
}