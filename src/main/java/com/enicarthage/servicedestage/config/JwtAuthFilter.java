package com.enicarthage.servicedestage.config;

import com.enicarthage.servicedestage.model.User;
import com.enicarthage.servicedestage.service.JwtService;
import com.enicarthage.servicedestage.service.UserService;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private  UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,@Nonnull HttpServletResponse response,@Nonnull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization"); //get the token from the header
        final String token;
        final String userName;
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response); //passe the request and the response to the next filter
            return;
        }
        token = authHeader.substring(7);
        userName = jwtService.extractUserName(token);  //extract the user email from jwt token
         if (userName == null && SecurityContextHolder.getContext().getAuthentication() == null) {
             UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
             if (jwtService.isTokenValid(token, (User) userDetails)){
                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                 SecurityContextHolder.getContext().setAuthentication(authToken);
             }
         }
         filterChain.doFilter(request,response);
    }
}
