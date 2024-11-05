package com.founderz.business.domain.persistence;

import com.founderz.business.domain.BusinessDomainReader;
import com.founderz.business.domain.BusinessDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BusinessRepository implements BusinessDomainReader, BusinessDomainWriter {
    private final BusinessRepository jpaRepository;
    private final BusinessDomainMapper mapper;
}
