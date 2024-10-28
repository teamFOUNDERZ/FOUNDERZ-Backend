package com.founderz.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
record TokenProperty(
        String issuer
) {
}
