package com.chak.Project.digital_banking_system.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
  private JWTFilter jwtFilter;
    @Bean
public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

   http.csrf(csrf -> csrf.disable()).authorizeHttpRequests
           (auth -> auth.requestMatchers( "/login",
                   "/register",
                   "/swagger-ui/**",
                   "/swagger-ui.html",
                   "/v3/api-docs/**").permitAll().anyRequest().authenticated())
           .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
   return http.build();
}

@Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
}
}
