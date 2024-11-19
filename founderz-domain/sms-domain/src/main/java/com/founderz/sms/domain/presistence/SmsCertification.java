package com.founderz.sms.domain.presistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class SmsCertification {
    private final String PREFIX = "sms:"; // key값이 중복되지 않도록 상수 선언
    private final int LIMIT_TIME = 3 * 60; // 인증번호 유효 시간

    private final SmsRedisRepository repository;

    // Redis에 저장
    public void createSmsCertification(String phone, String certificationNumber) {
        repository.save(new SmsEntity(PREFIX + phone, certificationNumber, Duration.ofSeconds(LIMIT_TIME).toMillis()));
    }

    // 휴대전화 번호에 해당하는 인증번호 불러오기
    public String getSmsCertification(String phone) {
        return repository.findById(PREFIX + phone).get().getAuthCode();
    }

    // 인증 완료 시, 인증번호 Redis에서 삭제
    public void deleteSmsCertification(String phone) {
        repository.deleteById(PREFIX + phone);
    }

    // Redis에 해당 휴대번호로 저장된 인증번호가 존재하는지 확인
    public boolean hasKey(String phone) {
        return Boolean.TRUE.equals(repository.existsById(PREFIX + phone));
    }
}
