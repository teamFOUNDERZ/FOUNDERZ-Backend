package com.founderz.security.cors;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.cors")
record CorsProperties(
        String allowHosts,
        String allowHeaders,
        String exposedHeaders
) {
}