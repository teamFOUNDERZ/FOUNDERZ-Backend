package com.founderz.security.aspect;

import com.founderz.common.exception.AccessDeniedException;
import com.founderz.common.presentation.annotation.RequiredRoles;
import com.founderz.common.security.UserRole;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
class RoleSecurityAspect {

    @Around("@annotation(com.founderz.presentation.annotation.RequiredRoles)")
    public Object checkRoles(final ProceedingJoinPoint joinPoint) throws Throwable {
        final var signature = (MethodSignature) joinPoint.getSignature();
        final var method = signature.getMethod();

        final var annotation = method.getAnnotation(RequiredRoles.class);

        final Set<String> roles = Arrays.stream(annotation.value())
                .map(UserRole::getRoleName)
                .collect(Collectors.toSet());

        final var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(roles::contains)) {
            return joinPoint.proceed();
        }

        throw new AccessDeniedException();
    }

}
