package com.founderz.sms.domain.presistence;

import org.springframework.data.repository.CrudRepository;

interface SmsRedisRepository extends CrudRepository<SmsEntity, String> {
}
