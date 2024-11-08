package com.founderz.security.current;

import com.founderz.internal.data.user.CurrentUserInfo;
import com.founderz.internal.data.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
interface CurrentUserMapper {
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    CurrentUserInfo toCurrentUserInfo(UserDto dto);
}
