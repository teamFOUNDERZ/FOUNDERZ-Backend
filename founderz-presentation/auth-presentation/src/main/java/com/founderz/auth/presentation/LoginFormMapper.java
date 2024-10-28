package com.founderz.auth.presentation;

import com.founderz.auth.application.dto.LoginDto;
import com.founderz.common.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
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
    @Mapping(target = "hashedPassword", source = "hashedPassword")
    protected abstract LoginDto mapToApplicationDto(LoginForm form);
}
