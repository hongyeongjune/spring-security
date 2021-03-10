package com.example.demo.form;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    /**
     * SecurityContext 안에 있는 Principal 정보를 찾고 싶을 때,
     * SecurityContextHolder 만 기억하면 찾을 수 있다.
     * SecurityContextHolder 그림을 기억하자
     */
    public void dashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 인증을 한 사용자의 정보
        Object principal = authentication.getPrincipal();
        // 인증을 한 사용자의 권한
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object credentials = authentication.getCredentials();
        boolean authenticated = authentication.isAuthenticated();
    }
}
