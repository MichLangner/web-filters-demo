package io.michlangner.webfiltersdemo.security;


import io.michlangner.webfiltersdemo.user.ApplicationUsersProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(req -> req.antMatchers("/viewer/**").permitAll())
                .authorizeRequests(req -> req.antMatchers("/admin/**").hasRole("ADMIN"))
                .authorizeRequests(req -> req.antMatchers("/user/**").hasRole("USER"))
                .httpBasic(Customizer.withDefaults()).build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(ApplicationUsersProperties applicationUsersProperties){
        List<UserDetails> userDetails = applicationUsersProperties.getAppUser().stream()
                .map(appUser -> User
                .withUsername(appUser.getUserName())
                .password("{noop}" + appUser.getPassword())
                .roles(appUser.getRoles().toArray(String[]::new))
                .build())
                .toList();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
