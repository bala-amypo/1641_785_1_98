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
