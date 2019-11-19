package ru.job4j.spring_app.Domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,ADMIN,MODER;
    @Override
    public String getAuthority() {
        return name();
    }
}