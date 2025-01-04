package com.java.bms.Jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret ;
    private Key key;
    private static final long EXPIRATION_TIME = 3600000; // 1 hour
    private static final long REFRESH_EXPIRATION_TIME = 86400000; // 24 hours

    @PostConstruct
    public void init() {
        this.key = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }

    /**
     * Generates a JWT token with the provided claims and subject.
     *
     * @param claims  Additional data to include in the token payload.
     * @param subject The subject (typically the username or user ID).
     * @return A signed JWT token as a String.
     */
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    /**
     * Generates a refresh token with a longer expiration time.
     *
     * @param subject The subject (typically the username or user ID).
     * @return A signed refresh token as a String.
     */
    public String generateRefreshToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    /**
     * Validates the provided JWT token.
     *
     * @param token The JWT token to validate.
     * @return Claims extracted from the token if valid.
     * @throws JwtException If the token is invalid or expired.
     */
    public Claims getTokens(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new JwtException("Token expired");
        } catch (JwtException e) {
            throw new JwtException("Token invalid");
        }
    }

    /**
     * Validates the provided JWT token.
     *
     * @param token The JWT token to validate.
     * @return true if the token is valid, false otherwise.
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true; // Token is valid
        } catch (ExpiredJwtException e) {
            System.err.println("Token expired: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.err.println("Malformed token: " + e.getMessage());
        } catch (SignatureException e) {
            System.err.println("Invalid signature: " + e.getMessage());
        } catch (JwtException e) {
            System.err.println("JWT validation failed: " + e.getMessage());
        }
        return false; // Token is invalid
    }


    /**
     * Extracts claims from the provided token.
     *
     * @param token The JWT token.
     * @return Claims from the token.
     */
    public Claims extractClaims(String token) {
        return getTokens(token);
    }

    /**
     * Extracts the subject (username or user ID) from the token.
     *
     * @param token The JWT token.
     * @return The subject as a String.
     */
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }
}
