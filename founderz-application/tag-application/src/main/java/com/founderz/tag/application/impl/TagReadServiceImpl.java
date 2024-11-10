package com.founderz.tag.application.impl;

import com.founderz.internal.data.tag.TagDto;
import com.founderz.tag.application.TagReadService;
import com.founderz.tag.domain.TagDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class TagReadServiceImpl implements TagReadService {
    private final TagDomainReader reader;

    @Override
    public List<TagDto> getAll() {
        return reader.findAll();
    }
}
