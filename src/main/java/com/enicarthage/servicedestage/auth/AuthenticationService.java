package com.enicarthage.servicedestage.auth;

import com.enicarthage.servicedestage.model.User;
import com.enicarthage.servicedestage.repository.UserRepository;
import com.enicarthage.servicedestage.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private  UserRepository repository;
     private  PasswordEncoder passwordEncoder;
     private JwtService jwtService;
     private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .nom(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        repository.save(user);
        var jwtToken= JwtService.generateToken((UserDetails) user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail());
        var jwtToken= JwtService.generateToken((UserDetails) user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();

    }
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password= authentication.getCredentials().toString();
         UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Mot de passe incorrect");
        }
        String token = JwtService.generateToken(userDetails);
        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

}
