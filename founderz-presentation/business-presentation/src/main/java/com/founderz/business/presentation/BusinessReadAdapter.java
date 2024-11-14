package com.founderz.business.presentation;

import com.founderz.business.application.BusinessReadService;
import com.founderz.business.presentation.response.BusinessListResponse;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.external.response.ListResponse;
import com.founderz.internal.function.sector.SectorReader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@WebRestAdapter("/api/business")
class BusinessReadAdapter {
    private final BusinessReadService businessReadService;
    private final SectorReader sectorReader;

    @GetMapping
    public ListResponse<BusinessListResponse> getAll() {
        final var result = businessReadService.getAll().stream()
                .map(business -> BusinessListResponse.create(business, sectorReader.getAllByBusinessId(business.businessId())))
                .toList();

        return ListResponse.create(result);
    }
}
