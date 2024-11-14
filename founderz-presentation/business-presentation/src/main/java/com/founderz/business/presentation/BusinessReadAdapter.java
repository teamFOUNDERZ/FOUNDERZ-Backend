package com.founderz.business.presentation;

import com.founderz.business.application.BusinessReadService;
import com.founderz.business.presentation.document.BusinessReadDocumentation;
import com.founderz.business.presentation.response.BusinessDetails;
import com.founderz.business.presentation.response.BusinessListResponse;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.vo.business.BusinessId;
import com.founderz.external.response.ListResponse;
import com.founderz.internal.function.sector.SectorReader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@WebRestAdapter("/api/business")
class BusinessReadAdapter implements BusinessReadDocumentation {
    private final BusinessReadService businessReadService;
    private final SectorReader sectorReader;

    @GetMapping
    public ListResponse<BusinessListResponse> getAll() {
        final var result = businessReadService.getAll().stream()
                .map(business -> BusinessListResponse.create(business, sectorReader.getAllByBusinessId(business.businessId())))
                .toList();

        return ListResponse.create(result);
    }

    @GetMapping("/{businessId}")
    public BusinessDetails getById(@PathVariable final String businessId) {
        final var business = businessReadService.getById(BusinessId.create(CryptoUtils.decrypt(businessId)));
        final var tags = sectorReader.getAllByBusinessId(business.businessId());

        return BusinessDetails.create(business, tags);
    }
}
