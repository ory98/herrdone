package com.example.herrdone.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.herrdone.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtManager {

    @Value("${jwt.secret}")
    @Getter
    private String secretKey;

    public String generateAccessToken(CustomPrincipal principal){
        return JWT.create()
                .withSubject(principal.getMemberType().getType())
                .withExpiresAt(new Date(System.nanoTime() + 1000*60*60))
                .withClaim("email", principal.getUsername())
                .withClaim("password", principal.getPassword())
                .sign(Algorithm.HMAC512(secretKey));
    }

    public String getMemberEmail(String token){
        return JWT
                .require(Algorithm.HMAC512(secretKey))
                .build()
                .verify(token)
                .getClaim("email")
                .asString();
    }

    public String getMemberType(String token){
        return JWT
                .require(Algorithm.HMAC512(secretKey))
                .build()
                .verify(token)
                .getSubject();
    }


}
