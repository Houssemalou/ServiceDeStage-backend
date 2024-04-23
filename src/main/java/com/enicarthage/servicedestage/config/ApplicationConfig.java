package com.enicarthage.servicedestage.config;

import com.enicarthage.servicedestage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private  UserRepository repository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> (UserDetails) repository.findByEmail(username);
    }
}
