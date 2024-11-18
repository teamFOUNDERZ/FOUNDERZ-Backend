package com.founderz.agreement.application.impl;

import com.founderz.agreement.application.AgreementWriteService;
import com.founderz.agreement.domain.AgreementDomainWriter;
import com.founderz.internal.data.agreement.AgreementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgreementWriteServiceImpl implements AgreementWriteService {
    private final AgreementDomainWriter writer;

    public void write(AgreementDto dto) {
        writer.save(dto);
    }
}
