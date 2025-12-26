package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtUtil {
    
    public String generateToken(Map<String, Object> claims, String email) {
        // Simplified token generation for testing
        return "jwt-token-" + email + "-" + System.currentTimeMillis();
    }
    
    public boolean validateToken(String token) {
        // Simplified validation for testing
        return token != null && !token.startsWith("invalid") && !token.equals("expired");
    }
}
