package com.founderz.auth.presentation;

import com.founderz.auth.application.AuthReadService;
import com.founderz.auth.document.AuthReadDocumentation;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@WebRestAdapter("/api/auth")
class AuthReadAdapter implements AuthReadDocumentation {
    private final AuthReadService readService;

    @GetMapping("/phone-number/validation")
    public ResponseEntity<Void> validateTelNumber(
            @RequestParam("phone-number") PhoneNumber phoneNumber
    ) {
        final var result = readService.isRegisteredPhoneNumber(phoneNumber);
        return getResponse(result);
    }

    @GetMapping("/account-id/validation")
    public ResponseEntity<Void> validateAccountId(
            @RequestParam("account-id") AccountId accountId
    ) {
        final var result = readService.isRegisteredAccount(accountId);
        return getResponse(result);
    }

    private static ResponseEntity<Void> getResponse(final boolean exists) {
        return exists
                ? ResponseEntity.status(HttpStatus.CONFLICT).build()
                : ResponseEntity.ok().build();
    }
}
