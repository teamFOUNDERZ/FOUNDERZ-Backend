package com.founderz.security;

import com.founderz.common.vo.auth.PasetoToken;
import dev.paseto.jpaseto.Claims;
import dev.paseto.jpaseto.Paseto;
import dev.paseto.jpaseto.PasetoException;
import dev.paseto.jpaseto.Pasetos;
import dev.paseto.jpaseto.Version;
import dev.paseto.jpaseto.lang.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
class TokenHandler implements Tokenizer, TokenUtils {
    private static final SecretKey SECRET_KEY;
    private static final KeyPair KEY_PAIR;

    private final TokenProperty tokenProperty;

    static {
        SECRET_KEY = Keys.secretKey();
        KEY_PAIR = Keys.keyPairFor(Version.V2);
    }

    @Override
    public PasetoToken generate(String subject) {
        final var now = Instant.now();

        final var token = Pasetos.V2.LOCAL.builder()
                .setSharedSecret(SECRET_KEY)
                .setIssuer(tokenProperty.issuer())
                .setIssuedAt(now)
                .setSubject(subject)
                .setExpiration(now.plus(2, ChronoUnit.HOURS))
                .setKeyId(UUID.randomUUID().toString())
                .compact();

        return new PasetoToken(token);
    }

    @Override
    public boolean validateToken(String authToken) {
        try {
            parseToken(authToken);
            return !isTokenExpired(authToken);
        } catch (PasetoException e) {
            return false;
        }
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).isBefore(Instant.now());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final var claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    private Instant extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims getClaims(String token) {
        return parseToken(token).getClaims();
    }

    private Paseto parseToken(String token) {
        var parser = Pasetos.parserBuilder()
                .setSharedSecret(SECRET_KEY)
                .setPublicKey(KEY_PAIR.getPublic())
                .build();

        return parser.parse(token);
    }
}
