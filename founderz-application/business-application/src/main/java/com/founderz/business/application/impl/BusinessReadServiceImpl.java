package com.founderz.business.application.impl;

import com.founderz.business.application.BusinessReadService;
import com.founderz.business.domain.BusinessDomainReader;
import com.founderz.internal.data.business.BusinessDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class BusinessReadServiceImpl implements BusinessReadService {
    private final BusinessDomainReader reader;

    @Override
    public List<BusinessDto> getAll() {
        return reader.findAll();
    }
}
