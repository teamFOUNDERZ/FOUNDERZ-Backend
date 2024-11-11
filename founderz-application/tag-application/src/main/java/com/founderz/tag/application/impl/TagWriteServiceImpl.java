package com.founderz.tag.application.impl;

import com.founderz.common.vo.tag.TagId;
import com.founderz.internal.data.tag.TagDto;
import com.founderz.tag.application.TagWriteService;
import com.founderz.tag.domain.TagDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TagWriteServiceImpl implements TagWriteService {
    private final TagDomainWriter writer;
    
    @Override
    public void create(final TagDto tagDto) {
        writer.save(tagDto);
    }

    @Override
    public void delete(final TagId tagId) {
        writer.delete(tagId);
    }
}
