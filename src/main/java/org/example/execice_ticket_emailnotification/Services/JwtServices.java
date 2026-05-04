package org.example.execice_ticket_emailnotification.Services;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtServices {
    private static  final String SecretKey = "Qg7ApCFZoOdWpOKB8bvidrMXsY0wZ5GUzA25k1zACe8";

    private static  final long Expiration = 24 * 60 * 60 * 1000;

    // il s'agit de rendre le code n bytecode
    private static Key getSecretKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims(claims)
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+Expiration)
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
