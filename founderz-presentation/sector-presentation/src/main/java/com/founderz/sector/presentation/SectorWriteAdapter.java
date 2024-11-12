package com.founderz.sector.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.sector.application.SectorWriteService;
import com.founderz.sector.presentation.document.SectorWriteDocumentation;
import com.founderz.sector.presentation.form.SectorAddForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@WebRestAdapter("/api/business/{businessId}/sectors")
class SectorWriteAdapter implements SectorWriteDocumentation {
    private final SectorWriteService writeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSector(@RequestBody SectorAddForm form, @PathVariable SecuredBusinessId businessId) {
        writeService.addSector(businessId.toBusinessId(), form.tagId().toTagId());
    }

    @DeleteMapping("/{tagId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSector(@PathVariable SecuredBusinessId businessId, @PathVariable SecuredTagId tagId) {
        writeService.removeSector(businessId.toBusinessId(), tagId.toTagId());
    }
}
