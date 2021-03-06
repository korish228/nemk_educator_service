package com.nemk.educator.interceptor;

import com.nemk.educator.security.JwtTokenUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;

public class AuthentificationTokenFilter extends OncePerRequestFilter {

    @Qualifier("jwtUserDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtill jwtTokenUtill;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

       String authToken = httpServletRequest.getHeader(this.tokenHeader);

       if (authToken != null && authToken.length() > 7){
           authToken = authToken.substring(7);
       }

       String username = jwtTokenUtill.getUsernameFromToken(authToken);

       if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
           UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
           boolean isValid = jwtTokenUtill.validateToken(authToken, userDetails);
           if (isValid){
               UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities() );
               authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
               SecurityContextHolder.getContext().setAuthentication(authentication);
           }
       }
       filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
