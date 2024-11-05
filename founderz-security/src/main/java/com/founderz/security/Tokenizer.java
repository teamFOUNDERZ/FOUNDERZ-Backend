package com.founderz.security;

import com.founderz.common.vo.auth.PasetoToken;

public interface Tokenizer {
    PasetoToken generate(String subject);
}
