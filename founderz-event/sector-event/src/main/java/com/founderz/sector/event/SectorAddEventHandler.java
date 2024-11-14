package com.founderz.sector.event;

import com.founderz.internal.event.BusinessSectorAddEvent;
import com.founderz.sector.application.SectorWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
class SectorAddEventHandler {
    private final SectorWriteService sectorWriteService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(BusinessSectorAddEvent event) {
        sectorWriteService.addSectors(event.businessId(), event.tagIds());
    }
}
