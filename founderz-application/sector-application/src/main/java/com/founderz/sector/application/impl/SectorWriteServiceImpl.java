package com.founderz.sector.application.impl;

import com.founderz.common.exception.AccessDeniedException;
import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.tag.TagId;
import com.founderz.internal.data.sector.SectorDto;
import com.founderz.internal.function.business.BusinessReader;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.internal.function.tag.TagReader;
import com.founderz.sector.application.SectorWriteService;
import com.founderz.sector.domain.SectorDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SectorWriteServiceImpl implements SectorWriteService {
    private final SectorDomainWriter writer;
    private final BusinessReader businessReader;
    private final TagReader tagReader;
    private final CurrentUser currentUser;
    
    @Override
    public void addSector(final BusinessId businessId, final TagId tagId) {
        validateCurrentUser(businessId);

        final var tag = tagReader.findById(tagId)
                .orElseThrow(() -> new DataNotFoundException("태그를 찾지 못했습니다."));

        writer.save(SectorDto.create(businessId, tagId, tag.name()));
    }

    @Override
    public void addSectors(final BusinessId businessId, final List<TagId> tagIds) {
        final var tags = tagReader.findAllByIds(tagIds.stream().map(TagId::tagId).toList());
        final var dtoList = tags.stream()
                .map(tag -> SectorDto.create(businessId, tag.id(), tag.name()))
                .toList();

        writer.saveAll(dtoList);
    }

    @Override
    public void removeSector(final BusinessId businessId, final TagId tagId) {
        validateCurrentUser(businessId);

        writer.delete(businessId, tagId);
    }

    private void validateCurrentUser(final BusinessId businessId) {
        final var user = currentUser.get();
        final var business = businessReader.findById(businessId)
                .orElseThrow(() -> new DataNotFoundException("사업 아이템을 찾지 못했습니다."));

        if (!user.accountId().equals(business.writerAccountId())) {
            throw new AccessDeniedException("해당 사업 아이템에 접근할 수 없습니다.");
        }
    }
}
