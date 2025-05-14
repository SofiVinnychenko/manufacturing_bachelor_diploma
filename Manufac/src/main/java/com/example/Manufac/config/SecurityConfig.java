package com.example.Manufac.config;

import com.example.Manufac.controllers.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/login", "/daily-report").permitAll()
                        .requestMatchers("/orders","/program", "/program/{id}/edit", "/program/{id}/remove",
                                "/reports", "/reports/{id}/pt", "/base-plan").hasRole("PLANNER")
                        .requestMatchers("/disp-processes", "/disp-processes/{id}/pt", "/monitoring", "/monitoring/repair", "/repair",
                                "/repair-info-disp").hasRole("DISPATCHER")
                        .requestMatchers("/subm-reports", "/repair/{id}/update", "/replace-mach",
                                "/update-status", "/update-statusE", "/update-statusS", "/update-statusD",
                                "/update-statusH", "/update-statusL", "/update-statusST", "/update-statusC", "/update-statusSC").hasRole("REPAIRER")
                        .requestMatchers("/img/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .successHandler(new CustomAuthenticationSuccessHandler()) // Добавляем свой обработчик
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );

        http.userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
