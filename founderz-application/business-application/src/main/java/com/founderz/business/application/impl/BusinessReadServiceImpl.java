package com.founderz.business.application.impl;

import com.founderz.business.application.BusinessReadService;
import com.founderz.business.domain.BusinessDomainReader;
import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.user.AccountId;
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

    @Override
    public BusinessDto getById(BusinessId businessId) {
        return reader.findById(businessId)
                .orElseThrow(() -> new DataNotFoundException("사업 아이템을 찾지 못했습니다."));
    }

    @Override
    public List<BusinessDto> getAllByWriterAccountId(AccountId writerAccountId) {
        return reader.findAllByWriterAccountId(writerAccountId);
    }
}
