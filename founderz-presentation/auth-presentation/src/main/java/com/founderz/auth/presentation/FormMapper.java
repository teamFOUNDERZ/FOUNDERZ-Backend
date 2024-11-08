package com.founderz.auth.presentation;

import com.founderz.auth.application.dto.LoginDto;
import com.founderz.auth.presentation.form.LoginForm;
import com.founderz.auth.presentation.form.RegisterForm;
import com.founderz.common.crypto.PasswordEncoder;
import com.founderz.internal.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface LoginFormMapper {

    @Mapping(target = "identifier", source = "identifier")
    @Mapping(target = "password", source = "password")
    LoginDto toApplicationDto(LoginForm form);
}

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
abstract class RegisterFormMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "securedPassword", expression = "java(SecuredPassword.create(passwordEncoder.encode(form.password())))")
    public abstract UserDto toDto(RegisterForm form);
}
