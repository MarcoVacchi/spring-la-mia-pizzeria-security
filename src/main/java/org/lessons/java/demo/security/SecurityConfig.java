package org.lessons.java.demo.security;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/pizze/create", "/pizze/edit/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/pizze/**").hasAuthority("ADMIN")
                        .requestMatchers("/ingredients", "/ingredients/**").hasAuthority("ADMIN")
                        .requestMatchers("/pizze", "/pizze/**").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers("/user").hasAuthority("USER")
                        .requestMatchers("/admin").hasAuthority("ADMIN")
                        .requestMatchers("/", "/**").permitAll())
                .formLogin(Customizer.withDefaults()) // login form default
                .logout(Customizer.withDefaults()) // logout default
                .exceptionHandling(Customizer.withDefaults()); // gestione eccezioni default

        return http.build();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        return authProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
