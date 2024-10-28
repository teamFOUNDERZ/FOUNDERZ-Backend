package com.founderz.user.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

import static org.mapstruct.ReportingPolicy.ERROR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        unmappedTargetPolicy = ERROR
)
interface UserDomainMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountId", expression = "java(dto.accountId().accountId())")
    @Mapping(target = "name", expression = "java(dto.name().name())")
    @Mapping(target = "type", expression = "java(UserEntity.Type.valueOf(dto.type().type()))")
    @Mapping(target = "tel", expression = "java(dto.tel().tel())")
    @Mapping(target = "password", expression = "java(dto.hashedPassword().password())")
    UserEntity toEntity(UserDomainDto dto);

    @Mapping(target = "id", expression = "java(new UserId(entity.getId()))")
    @Mapping(target = "accountId", expression = "java(new AccountId(entity.getAccountId()))")
    @Mapping(target = "name", expression = "java(new AccountName(entity.getName()))")
    @Mapping(target = "type", expression = "java(new AccountType(entity.getType().name()))")
    @Mapping(target = "tel", expression = "java(new TelNumber(entity.getTel()))")
    @Mapping(target = "hashedPassword", expression = "java(new HashedPassword(entity.getPassword()))")
    UserDomainDto toDto(UserEntity entity);

    default Optional<UserDomainDto> toOptionalDto(Optional<UserEntity> entity) {
        return entity.map(this::toDto);
    }
}
