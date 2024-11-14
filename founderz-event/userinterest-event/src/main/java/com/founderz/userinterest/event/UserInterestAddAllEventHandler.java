package com.founderz.userinterest.event;

import com.founderz.internal.event.UserInterestAddEvent;
import com.founderz.userinterest.application.UserInterestWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
class UserInterestAddAllEventHandler {
    private final UserInterestWriteService userInterestWriteService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(UserInterestAddEvent event) {
        userInterestWriteService.addUserInterests(event.userId(), event.tagIds());
    }
}
