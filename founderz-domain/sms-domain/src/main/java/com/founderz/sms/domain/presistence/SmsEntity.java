package com.founderz.sms.domain.presistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "sms")
class SmsEntity {
    @Id
    private String id;

    @Indexed
    private String authCode;

    @TimeToLive
    private Long expiration;
}
