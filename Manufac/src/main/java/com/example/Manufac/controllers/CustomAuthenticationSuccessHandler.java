package com.example.Manufac.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String role = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> authority.startsWith("ROLE_"))
                .findFirst()
                .orElse("");

        String redirectUrl;

        if (role.equals("ROLE_PLANNER")) {
            redirectUrl = "/orders";
        } else if (role.equals("ROLE_DISPATCHER")) {
            redirectUrl = "/disp-processes";
        } else if (role.equals("ROLE_REPAIRER")) {
            redirectUrl = "/subm-reports";
        } else {
            redirectUrl = "/default";
        }

        response.sendRedirect(redirectUrl);
    }
}
