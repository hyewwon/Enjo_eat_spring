package com.enjo_eat_spring.enjo_eat_spring.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.nio.file.Path;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(AbstractHttpConfigurer::disable)
                .headers((headerConfig) ->
                        headerConfig.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/", "/login", "/join", "/auth-api/login", "/auth-api/join", "/assets/**", "/js/**", "/css/**").permitAll()
                                .anyRequest().authenticated())
                .formLogin((formLoin) ->
                        formLoin
                                .loginPage("/login")
                                .usernameParameter("userId")
                                .passwordParameter("password")
                                .loginProcessingUrl("/auth-api/login")
                                .defaultSuccessUrl("/", true))
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/"));

        return http.build();

    }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
