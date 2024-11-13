package com.founderz.business.application.impl;

import com.founderz.business.application.BusinessWriteService;
import com.founderz.business.domain.BusinessDomainWriter;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.event.BusinessSectorAddEvent;
import com.founderz.internal.function.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BusinessWriteServiceImpl implements BusinessWriteService {
    private final BusinessDomainWriter writer;
    private final CurrentUser currentUser;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void write(final BusinessDto dto, final List<SecuredTagId> tagIds) {
        BusinessDto newDto = dto.setWriterAccountId(currentUser.get().accountId());

        final var saveBusiness = writer.save(newDto);

        eventPublisher.publishEvent(BusinessSectorAddEvent.create(tagIds, saveBusiness.businessId()));
    }
}
