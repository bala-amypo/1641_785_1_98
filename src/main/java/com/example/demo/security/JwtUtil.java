package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtUtil {
    
    public String generateToken(String email) {
        return "jwt-token-" + email;
    }
    
    public String generateToken(Map<String, Object> claims, String email) {
        return generateToken(email);
    }
    
    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token-");
    }
}
