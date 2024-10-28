package com.founderz.security;

import com.founderz.common.vo.PasetoToken;

public interface Tokenizer {
    PasetoToken generate(String subject);
}
