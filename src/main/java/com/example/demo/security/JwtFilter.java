// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;

// public class JwtFilter extends OncePerRequestFilter {
    
//     private final JwtUtil jwtUtil;
    
//     public JwtFilter(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }
    
//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
//                                   FilterChain filterChain) throws ServletException, IOException {
//         String header = request.getHeader("Authorization");
//         if (header != null && header.startsWith("Bearer ")) {
//             String token = header.substring(7);
//             if (jwtUtil.validateToken(token)) {
                
//             }
//         }
//         filterChain.doFilter(request, response);
//     }
// }


// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;
// import java.util.Collections;

// public class JwtFilter extends OncePerRequestFilter {

//     private final JwtUtil jwtUtil;

//     public JwtFilter(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     protected void doFilterInternal(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             FilterChain filterChain
//     ) throws ServletException, IOException {

//         String authHeader = request.getHeader("Authorization");

//         if (authHeader != null && authHeader.startsWith("Bearer ")) {

//             String token = authHeader.substring(7);

//             // Validate token
//             if (jwtUtil.validateToken(token)
//                     && SecurityContextHolder.getContext().getAuthentication() == null) {

//                 // 🔹 Extract email from token: jwt-token-email-timestamp
//                 String email = extractEmailFromToken(token);

//                 UsernamePasswordAuthenticationToken authentication =
//                         new UsernamePasswordAuthenticationToken(
//                                 email,
//                                 null,
//                                 Collections.emptyList()
//                         );

//                 authentication.setDetails(
//                         new WebAuthenticationDetailsSource().buildDetails(request)
//                 );

//                 SecurityContextHolder.getContext()
//                         .setAuthentication(authentication);
//             }
//         }

//         filterChain.doFilter(request, response);
//     }

//     // 🔑 Helper method for YOUR token format
//     private String extractEmailFromToken(String token) {
//         // token format: jwt-token-email-timestamp
//         String[] parts = token.split("-");
//         return parts.length >= 3 ? parts[2] : null;
//     }
// }


package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.startsWith("/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if (jwtUtil.validateToken(token)
                    && SecurityContextHolder.getContext().getAuthentication() == null) {

                String email = extractEmailFromToken(token);
                

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                Collections.emptyList()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    private String extractEmailFromToken(String token) {
        String[] parts = token.split("-");
        return parts.length >= 3 ? parts[2] : null;
    }
}
