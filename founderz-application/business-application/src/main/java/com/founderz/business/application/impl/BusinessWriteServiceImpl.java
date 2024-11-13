package com.founderz.business.application.impl;

import com.founderz.business.application.BusinessWriteService;
import com.founderz.business.domain.BusinessDomainWriter;
import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.function.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessWriteServiceImpl implements BusinessWriteService {
    private final BusinessDomainWriter writer;
    private final CurrentUser currentUser;

    @Override
    public void write(final BusinessDto dto) {
        BusinessDto newDto = dto.setWriterAccountId(currentUser.get().accountId());

        writer.save(newDto);
    }
}
