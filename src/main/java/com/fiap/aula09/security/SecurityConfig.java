package com.fiap.aula09.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity()
@EnableGlobalMethodSecurity()
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER_ADMIN")
                .build();
        UserDetails pedrinhoMinecraft = User.builder()
                .username("Pedrinho Minecraft")
                .password("venoninho extremi")
                .roles("PEDRINHO_MINE")
                .build();

        return new InMemoryUserDetailsManager(admin, pedrinhoMinecraft);
    }
}
