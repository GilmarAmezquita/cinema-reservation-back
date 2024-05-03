package icine.cinema.dashboard.domain.service;

import icine.cinema.dashboard.infrastructure.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        claims.put("roles", user.getAuthorities());
        return createToken(claims, user.getUsername());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        Date expirationDate = extractExpiration(token);
        if (expirationDate.before(new Date())) {
            return false;
        }
        String username = extractUsername(token);
        return userDetails.getUsername().equals(username) && !expirationDate.before(new Date());
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey())
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public Date extractExpiration(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody().getExpiration();
    }
}
