package com.founderz.security;

import com.founderz.common.exception.BadRequestException;
import com.founderz.common.vo.AccountId;
import com.founderz.user.domain.UserDomainReader;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class SecurityWebFilter extends OncePerRequestFilter {
    private final UserDomainReader userDomainReader;
    private final TokenUtils tokenUtils;

    private static final String BEARER_PREFIX = "Bearer ";
    private static final int BEARER_PREFIX_LENGTH = BEARER_PREFIX.length();

    @Override
    protected void doFilterInternal(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain filterChain
    ) throws ServletException, IOException {
        resolveHeaderToken(request)
                .filter(tokenUtils::validateToken)
                .map(tokenUtils::extractUsername)
                .filter(StringUtils::isNotEmpty)
                .ifPresent(this::setAuthentication);

        filterChain.doFilter(request, response);
    }

    private Optional<String> resolveHeaderToken(final HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(token -> token.startsWith(BEARER_PREFIX))
                .map(token -> token.substring(BEARER_PREFIX_LENGTH));
    }

    private void setAuthentication(final String username) {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            final var details = getUserRole(username);
            final var authentication = new UsernamePasswordAuthenticationToken(
                    details,
                    null,
                    details.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private UserDetails getUserRole(final String username) {
        final var user = userDomainReader.findByAccountId(new AccountId(username))
                .orElseThrow(BadRequestException::new);

        return new User(
                username,
                null,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.type().type()))
        );
    }
}