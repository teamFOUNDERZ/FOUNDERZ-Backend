package com.founderz.sector.domain.presistence;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.internal.data.sector.SectorDto;
import com.founderz.internal.data.userinterest.UserInterestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface SectorDomainMapper {
    @Mapping(target = "businessId", expression = "java(BusinessId.create(entity.getId().businessId()))")
    @Mapping(target = "tagId", expression = "java(TagId.create(entity.getId().tagId()))")
    @Mapping(target = "tagName", expression = "java(TagName.create(entity.getCacheTagName()))")
    SectorDto toDto(SectorEntity entity);

    @Mapping(target = "id", source = ".", qualifiedByName = "createId")
    @Mapping(target = "cacheTagName", expression = "java(dto.tagName().tagName())")
    SectorEntity toEntity(SectorDto dto);

    @Named("createId")
    default SectorEntityId createId(SectorDto dto) {
        return new SectorEntityId(
                dto.businessId().businessId(),
                dto.tagId().tagId()
        );
    }

    default List<SectorEntity> toEntityList(List<SectorDto> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .toList();
    }
}
