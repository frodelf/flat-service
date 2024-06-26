package com.example.flatservice.config;

import com.example.flatservice.jwt.JwtTokenFilter;
import com.example.flatservice.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterConfig {
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests(
                        auth -> {
                            auth
                                .requestMatchers("/api/v1/flat/admin/**").hasRole("ADMIN")
                                .requestMatchers("/api/v1/flat/add").hasAnyRole("NOTARY", "ADMIN")
                                .requestMatchers("/api/v1/flat/**").authenticated()
                                .requestMatchers("/api/v1/enum/**").authenticated()
                                .anyRequest().permitAll();
                        })
                .addFilterAfter(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
        return httpSecurity.build();
    }
}