package com.founderz.auth.presentation;

import com.founderz.auth.application.dto.LoginDto;
import com.founderz.auth.application.dto.RegisterDto;
import com.founderz.common.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
abstract class LoginFormMapper {

    public LoginDto toApplicationDto(LoginForm form) {
        try {
            return mapToApplicationDto(form);
        } catch (Exception e) {
            throw new BadRequestException("잘못된 login form 입니다.", e);
        }
    }

    @Mapping(target = "identifier", source = "identifier")
    @Mapping(target = "password", source = "password")
    protected abstract LoginDto mapToApplicationDto(LoginForm form);
}

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
abstract class RegisterFormMapper {

    public RegisterDto toApplicationDto(RegisterForm form) {
        try {
            return mapToApplicationDto(form);
        } catch (Exception e) {
            throw new BadRequestException("잘못된 register form 입니다.", e);
        }
    }

    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "password", source = "password")
    protected abstract RegisterDto mapToApplicationDto(RegisterForm form);
}
