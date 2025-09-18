package com.authuser.auth_project.Config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Secure random key (HS256 -> 256 bits)
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(secretKey)  // automatically strong enough
                .compact();
    }

    public String extractUsername(String token)
    {
        String userNameFromToken = Jwts.parserBuilder().
        setSigningKey(secretKey).
        build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();

        System.out.println("userNameFromToken: "+userNameFromToken);
        return userNameFromToken;
    }

    public boolean isTokenExpired(String token)
    {
        return Jwts.parserBuilder()
        .setSigningKey(secretKey)
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getExpiration()
        .before(new Date());
    }

    public boolean validateToken(String token, String username) {

        String extractedUsername = extractUsername(token);

        return extractedUsername.equals(username) && !isTokenExpired(token);


    }




}
