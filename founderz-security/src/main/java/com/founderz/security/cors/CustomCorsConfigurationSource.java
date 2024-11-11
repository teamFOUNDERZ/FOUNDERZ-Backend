package com.founderz.security.cors;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Primary
@Component
@RequiredArgsConstructor
class CustomCorsConfigurationSource implements CorsConfigurationSource {
    private final CorsProperties corsProperties;

    @Override
    public CorsConfiguration getCorsConfiguration(final HttpServletRequest request) {
        final var configuration = new CorsConfiguration();

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedOrigins(List.of(corsProperties.allowHosts().split(",")));
        configuration.setAllowedHeaders(List.of(corsProperties.allowHeaders().split(",")));
        configuration.setExposedHeaders(List.of(corsProperties.exposedHeaders().split(",")));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return configuration;
    }
}