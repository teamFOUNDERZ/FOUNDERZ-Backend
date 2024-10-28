package com.founderz.auth.application;

import com.founderz.auth.application.dto.LoginDto;
import com.founderz.auth.application.dto.RegisterDto;
import com.founderz.common.crypto.PasswordEncoder;
import com.founderz.common.exception.BadRequestException;
import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.PasetoToken;
import com.founderz.common.vo.TelNumber;
import com.founderz.security.Tokenizer;
import com.founderz.user.application.UserApplicationDto;
import com.founderz.user.domain.UserDomainReader;
import com.founderz.user.domain.UserDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface AuthWriteService {
    void register(RegisterDto dto);
    PasetoToken login(LoginDto dto);
}

@Service
@RequiredArgsConstructor
class AuthWriteServiceImpl implements AuthWriteService {
    private final PasswordEncoder passwordEncoder;
    private final AuthApplicationMapper mapper;
    private final UserDomainWriter writer;
    private final UserDomainReader reader;
    private final Tokenizer tokenizer;

    @Override
    public void register(final RegisterDto dto) {
        validateRegisterDto(dto);

        final var domainDto = mapper.toDomainDto(dto);
        writer.save(domainDto);
    }

    @Override
    public PasetoToken login(final LoginDto dto) {
        final var identifier = dto.identifier();
        UserApplicationDto user;

        if (TelNumber.isTelNumber(identifier)) {
            user = getUserByTelNumber(identifier.toTelNumber());
        } else {
            user = getUserByAccountId(identifier.toAccountId());
        }

        validatePassword(user, dto);

        return tokenizer.generate(user.accountId().accountId());
    }

    private void validatePassword(final UserApplicationDto applicationDto, final LoginDto request) {
        if (!passwordEncoder.matches(request.password(), applicationDto.hashedPassword())) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다.");
        }
    }

    private UserApplicationDto getUserByAccountId(final AccountId accountId) {
        final var domainDto = reader.findByAccountId(accountId)
                .orElseThrow();

        return mapper.toApplicationDto(domainDto);
    }

    private UserApplicationDto getUserByTelNumber(final TelNumber telNumber) {
        final var domainDto = reader.findByTel(telNumber)
                .orElseThrow();

        return mapper.toApplicationDto(domainDto);
    }

    private void validateRegisterDto(final RegisterDto dto) {
        if (reader.existsByAccountId(dto.accountId())) {
            throw new BadRequestException("입력된 계정의 아이디가 이미 사용 중입니다.");
        }
        if (reader.existsByTel(dto.tel())) {
            throw new BadRequestException("입력된 계정의 전화번호가 이미 사용 중입니다.");
        }
    }
}
