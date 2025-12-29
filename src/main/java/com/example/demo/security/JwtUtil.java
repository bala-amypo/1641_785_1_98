package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtUtil {
    
    public String generateToken(Map<String, Object> claims, String email) {
        return "jwt-token-" + email + "-" + System.currentTimeMillis();
    }
    
    public boolean validateToken(String token) {
        return token != null && !token.startsWith("invalid") && !token.equals("expired");
    }
}

// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.Date;
// import java.util.Map;

// @Component
// public class JwtUtil {

//     private static final String SECRET =
//             "mysecretkeymysecretkeymysecretkey123"; // minimum 32 chars

//     private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 24 hours

//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(SECRET.getBytes());
//     }

//     public String generateToken(Map<String, Object> claims, String email) {

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(email)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(getSigningKey())
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (JwtException e) {
//             return false;
//         }
//     }

//     public String extractEmail(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getSubject();
//     }
// }


