package com.founderz.investment.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.external.response.ListResponse;
import com.founderz.investment.application.InvestmentReadService;
import com.founderz.investment.presentation.document.InvestmentReadDocumentation;
import com.founderz.investment.presentation.response.InvestmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@WebRestAdapter("/api/investment")
class InvestmentReadAdapter implements InvestmentReadDocumentation {
    private final InvestmentReadService investmentReadService;

    @GetMapping("/received-investment")
    public ListResponse<InvestmentResponse> getReceivedInvestmentRequest() {
        final var result = investmentReadService.getReceivedInvestmentRequest().stream()
                .map(InvestmentResponse::create)
                .toList();

        return ListResponse.create(result);
    }

    @GetMapping("/my-investment")
    public ListResponse<InvestmentResponse> getMyInvestment() {
        final var result = investmentReadService.getMyInvestment().stream()
                .map(InvestmentResponse::create)
                .toList();

        return ListResponse.create(result);
    }
}