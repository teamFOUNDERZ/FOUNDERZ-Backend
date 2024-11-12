package com.founderz.security.cors;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@RequiredArgsConstructor
class CorsConfiguration {
    private final CorsProperties corsProperties;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final var configuration = new org.springframework.web.cors.CorsConfiguration();

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedOrigins(List.of(corsProperties.allowHosts().split(",")));
        configuration.setAllowedHeaders(List.of(corsProperties.allowHeaders().split(",")));
        configuration.setExposedHeaders(List.of(corsProperties.exposedHeaders().split(",")));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}