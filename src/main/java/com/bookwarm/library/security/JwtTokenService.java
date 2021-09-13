package com.bookwarm.library.security;

import com.bookwarm.library.persistence.model.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenService {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenService.class);
    private final String secretKey = "mushroomLeaseImpulse";
    private final int expirationTime = 180;

    public String buildToken(User user) {
        Date issuedAt = new Date();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole().getName())
                .setIssuedAt(issuedAt)
                .setExpiration(new Date(issuedAt.getTime() + (expirationTime * 60 * 1000)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("Токен истёк: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Токен не поддерживается: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Токен сгенерирован с ошибкой: {}", e.getMessage());
        } catch (SignatureException e) {
            logger.error("Токен неверно подписан: {}", e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
