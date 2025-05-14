package com.example.Manufac.controllers;

import com.example.Manufac.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Здесь вы можете преобразовать роли пользователя в объекты GrantedAuthority
        // В данном примере предполагается, что роли представлены строками
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Вы можете реализовать логику проверки срока действия учетной записи
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Вы можете реализовать логику проверки блокировки учетной записи
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Вы можете реализовать логику проверки срока действия учетных данных
    }

    @Override
    public boolean isEnabled() {
        return true; // Вы можете реализовать логику проверки активации учетной записи
    }
}
