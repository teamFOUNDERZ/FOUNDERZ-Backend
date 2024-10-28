package com.founderz.security;

interface TokenUtils {
    boolean validateToken(String token);
    String extractUsername(String token);
}
