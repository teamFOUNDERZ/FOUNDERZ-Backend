package com.founderz.user.domain;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface UserDomainMapper {

    UserEntity toEntity(UserDomainDto dto);
    UserDomainDto toDto(UserEntity entity);

}
