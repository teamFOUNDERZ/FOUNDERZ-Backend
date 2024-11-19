package com.founderz.sector.event;

import com.founderz.internal.event.BusinessSectorAddEvent;
import com.founderz.sector.application.SectorWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
class SectorAddEventHandler {
    private final SectorWriteService sectorWriteService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(BusinessSectorAddEvent event) {
        sectorWriteService.addSectors(event.businessId(), event.tagIds());
    }
}
