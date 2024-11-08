package com.founderz.auth.application.impl;

import com.founderz.auth.application.AuthWriteService;
import com.founderz.auth.application.dto.LoginDto;
import com.founderz.common.exception.DataNotFoundException;
import com.founderz.internal.function.security.PasswordEncoder;
import com.founderz.common.exception.BadRequestException;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.auth.PasetoToken;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.internal.data.user.UserDto;
import com.founderz.security.Tokenizer;
import com.founderz.user.domain.UserDomainReader;
import com.founderz.user.domain.UserDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class AuthWriteServiceImpl implements AuthWriteService {
    private final PasswordEncoder passwordEncoder;
    private final UserDomainWriter writer;
    private final UserDomainReader reader;
    private final Tokenizer tokenizer;

    @Override
    public void register(final UserDto dto) {
        validateRegisterDto(dto);
        writer.save(dto);
    }

    @Override
    public PasetoToken login(final LoginDto dto) {
        final var identifier = dto.identifier();
        UserDto user;

        if (PhoneNumber.isTelNumber(identifier)) {
            user = getUserByTelNumber(identifier.toTelNumber());
        } else {
            user = getUserByAccountId(identifier.toAccountId());
        }

        validatePassword(user, dto);

        return tokenizer.generate(user.accountId().accountId());
    }

    private void validatePassword(final UserDto applicationDto, final LoginDto request) {
        if (!passwordEncoder.matches(request.password(), applicationDto.securedPassword())) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다.");
        }
    }

    private UserDto getUserByAccountId(final AccountId accountId) {
        return reader.findByAccountId(accountId)
                .orElseThrow(() -> new DataNotFoundException(accountId.accountId() + "의 계정 아이디를 사용하는 사용자를 찾지 못했습니다."));
    }

    private UserDto getUserByTelNumber(final PhoneNumber phoneNumber) {
        return reader.findByTel(phoneNumber)
                .orElseThrow(() -> new DataNotFoundException(phoneNumber.phoneNumber() + "의 전화번호를 사용하는 사용자를 찾지 못했습니다."));
    }

    private void validateRegisterDto(final UserDto dto) {
        if (reader.existsByAccountIdOrPhoneNumber(dto.accountId(), dto.phoneNumber())) {
            throw new BadRequestException("입력된 계정의 아이디 또는 전화번호가 이미 사용 중입니다.");
        }
    }
}
