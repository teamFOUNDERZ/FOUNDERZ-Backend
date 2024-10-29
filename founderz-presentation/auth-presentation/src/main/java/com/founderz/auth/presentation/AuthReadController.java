package com.founderz.auth.presentation;

import com.founderz.auth.application.AuthReadService;
import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.TelNumber;
import lombok.RequiredArgsConstructor;
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
    BooleanResponse checkTelNumber(@RequestParam String tel) {
        final var result = readService.existsByTel(new TelNumber(tel));
        return new BooleanResponse(result);
    }

    @GetMapping("/check-accountid")
    BooleanResponse checkAccountId(
            @RequestParam(name = "accountid") String accountId
    ) {
        final var result = readService.existsByAccountId(new AccountId(accountId));
        return new BooleanResponse(result);
    }

    private record BooleanResponse(
            boolean result
    ) {
    }
}
