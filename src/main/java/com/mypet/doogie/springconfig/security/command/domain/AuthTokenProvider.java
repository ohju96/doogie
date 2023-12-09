package com.mypet.doogie.springconfig.security.command.domain;

import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.Map;

public interface AuthTokenProvider <T> {

    T createToken(String accountId, String role, Map<String, Object> claims, Date expiredDate);

    T convertAuthToken(String token);

    Authentication getAuthentication(T authToken);

    T createAccessToken(String accountId, String role, Map<String, Object> claims);

    T createRefreshToken(String accountId, String role, Map<String, Object> claims);
}
