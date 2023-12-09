package com.mypet.doogie.springconfig.security.infra;

import com.mypet.doogie.springconfig.security.command.domain.AuthToken;
import com.mypet.doogie.springconfig.security.command.domain.AuthTokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.security.Key;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.mypet.doogie.springconfig.security.command.domain.MemberConstants.ACCESS_TOKEN_TYPE_VALUE;
import static com.mypet.doogie.springconfig.security.command.domain.MemberConstants.REFRESH_TOKEN_TYPE_VALUE;

@Component
@RequiredArgsConstructor
public class JwtProvider implements AuthTokenProvider<JwtToken> {

    private final RedisTemplate<String, String> redisTemplate;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token.access-expiration}")
    private long accessExpires;

    @Value("${jwt.token.refresh-expiration}")
    private long refreshExpires;

    private Key key;

    //    @PostConstruct // 객체 생성 후 초기화
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public JwtToken createToken(String accountId, String role, Map<String, Object> claims, Date expiredDate) {
        return new JwtToken(accountId.toString(), key, role, claims, expiredDate);
    }

    @Override
    public JwtToken convertAuthToken(String token) {
        return new JwtToken(token, key);
    }

    @Override
    public Authentication getAuthentication(JwtToken authToken) {

        if (authToken.validate()) {

            Claims claims = authToken.getDate();

            if (!claims.get("type").equals(ACCESS_TOKEN_TYPE_VALUE)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "token type is not access");
            }

            Set<SimpleGrantedAuthority> authorities = Collections.singleton(
                    new SimpleGrantedAuthority(claims.get(AuthToken.AUTHORITIES_TOKEN_KEY, String.class)));

            User principal = new User(claims.getSubject(), "", authorities);

            return new UsernamePasswordAuthenticationToken(principal, authToken, authorities);
        } else {
            throw new JwtException("token Error");
        }
    }

    @Override
    public JwtToken createAccessToken(String accountId, String role, Map<String, Object> claims) {
        final Map<String, Object> claimsWithType = new HashMap<>() {{
            put("type", ACCESS_TOKEN_TYPE_VALUE);
        }};

        return new JwtToken(accountId.toString(),
                key, role, claimsWithType, new Date(System.currentTimeMillis() + 1000 * 60 * 20));
    }

    @Override
    public JwtToken createRefreshToken(String accountId, String role, Map<String, Object> claims) {
        final Map<String, Object> claimsWithType = new HashMap<>() {{
            put("type", REFRESH_TOKEN_TYPE_VALUE);
        }};

        final JwtToken jwtToken = new JwtToken(accountId.toString(), key, role, claimsWithType, new Date(System.currentTimeMillis() + 1000 * 60 * 20));
        redisTemplate.opsForValue().set(accountId.toString(), jwtToken.getToken(), refreshExpires, TimeUnit.SECONDS);

        return jwtToken;
    }
}

