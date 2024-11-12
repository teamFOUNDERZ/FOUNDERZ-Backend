package com.founderz.sector.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.external.response.ListResponse;
import com.founderz.sector.application.SectorReadService;
import com.founderz.sector.presentation.document.SectorReadDocumentation;
import com.founderz.sector.presentation.response.SectorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@WebRestAdapter("/api/business/{businessId}/sectors")
class SectorReadAdapter implements SectorReadDocumentation {
    private final SectorReadService readService;

    @GetMapping
    public ListResponse<SectorResponse> getBusinessSectors(@PathVariable SecuredBusinessId businessId) {
        final var result = readService.getBusinessSectors(businessId.toBusinessId()).stream()
                .map(SectorResponse::create)
                .toList();

        return ListResponse.create(result);
    }
}
