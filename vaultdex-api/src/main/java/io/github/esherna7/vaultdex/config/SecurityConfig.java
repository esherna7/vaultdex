package io.github.esherna7.vaultdex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
            SecurityContextRepository securityContextRepository) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .securityContext(securityContext -> securityContext
                .securityContextRepository(securityContextRepository))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/cards/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/users/login").permitAll()
                .anyRequest().authenticated())
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
