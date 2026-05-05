package org.example.execice_ticket_emailnotification.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class JwtServices {


        // Clé secrète pour signer les tokens (doit être sécurisée en production)
        private static final String SECRET_KEY = "Qg7ApCFZoOdWpOKB8bvidrMXsY0wZ5GUzA25k1zACe8";

        // Durée de validité du token : 24 heures
        private static final long EXPIRATION = 24 * 60 * 60 * 1000;

        /**
         * Convertit la clé secrète en format Key pour le chiffrement
         */
        private static Key getSecretKey() {
            byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
            return Keys.hmacShaKeyFor(keyBytes);
        }

        /**
         * Génère un token JWT avec des claims personnalisés
         * @param extraClaims Claims supplémentaires à ajouter
         * @param email Email de l'utilisateur
         * @return Le token JWT généré
         */
        public String generateToken(Map<String, Object> extraClaims, String email) {
            return createToken(extraClaims, email);
        }

        /**
         * Crée le token JWT
         */
        private String createToken(Map<String, Object> claims, String subject) {
            return Jwts.builder()
                    .claims(claims)
                    .subject(subject)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                    .signWith(getSecretKey())
                    .compact();
        }

        /**
         * Extrait tous les claims d'un token
         */
        private Claims extractAllClaims(String token) {
            return Jwts.parser()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }

        /**
         * Extrait un claim spécifique d'un token
         */
        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }

        /**
         * Extrait l'email (subject) du token
         */
        public String extractEmail(String token) {
            return extractClaim(token, Claims::getSubject);
        }

        /**
         * Extrait la date d'expiration du token
         */
        public Date extractExpiration(String token) {
            return extractClaim(token, Claims::getExpiration);
        }

        /**
         * Valide le token pour un email donné
         */
        public boolean validateToken(String token, String email) {
            final String tokenEmail = extractEmail(token);
            return (tokenEmail.equals(email) && !isTokenExpired(token));
        }
          /**
        * Vérifie si le token a expiré
        */
        private boolean isTokenExpired(String token) {
            return extractExpiration(token).before(new Date());
          }
    }

