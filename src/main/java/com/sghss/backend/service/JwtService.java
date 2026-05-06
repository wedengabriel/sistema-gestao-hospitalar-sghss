package com.sghss.backend.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "sghss_chave_super_secreta_jwt_2026_backend";

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String gerarToken(String cpf) {
        return Jwts.builder()
                .subject(cpf)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }
}