package com.avaxia.lms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecParams {
    @Value("${security.jwt.secret}")
    public String SECRET;
}
