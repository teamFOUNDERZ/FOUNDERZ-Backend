package com.founderz.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "security.token")
record TokenProperty(
        String issuer
) {
}
