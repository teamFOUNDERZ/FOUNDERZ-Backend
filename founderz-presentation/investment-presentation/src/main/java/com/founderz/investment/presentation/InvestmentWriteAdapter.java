package com.founderz.investment.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.investment.application.InvestmentWriteService;
import com.founderz.investment.presentation.document.InvestmentWriteDocumentation;
import com.founderz.investment.presentation.form.RequestInvestmentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@WebRestAdapter("/api/investment")
class InvestmentWriteAdapter implements InvestmentWriteDocumentation {
    private final InvestmentWriteService writeService;
    private final RequestInvestmentFormMapper requestInvestmentFormMapper;

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.CREATED)
    public void request(@RequestBody RequestInvestmentForm form) {
        final var internalDto = requestInvestmentFormMapper.toDto(form);

        writeService.request(internalDto);
    }
}
