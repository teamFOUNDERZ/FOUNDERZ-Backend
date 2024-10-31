package com.founderz.auth.presentation;

import com.founderz.auth.application.AuthReadService;
import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.TelNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
class AuthReadController {
    private final AuthReadService readService;

    @GetMapping("/check-tel")
    ResponseEntity<Void> checkTelNumber(@RequestParam String tel) {
        final var result = readService.existsByTel(new TelNumber(tel));
        return getResponse(result);
    }

    @GetMapping("/check-accountid")
    ResponseEntity<Void> checkAccountId(
            @RequestParam(name = "accountid") String accountId
    ) {
        final var result = readService.existsByAccountId(new AccountId(accountId));
        return getResponse(result);
    }

    private static ResponseEntity<Void> getResponse(final boolean result) {
        final var httpStatus = result
                ? HttpStatus.ACCEPTED
                : HttpStatus.NOT_ACCEPTABLE;

        return ResponseEntity.status(httpStatus)
                .build();
    }
}
