package com.applicationservices.security.jwt;

import com.applicationservices.security.services.UserDetailsPrincipal;
import com.applicationservices.security.services.impl.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            String refreshJwt = parseRefreshToken(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt, null, false)
                    || refreshJwt != null && jwtUtils.validateJwtToken(null,refreshJwt, true)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                UserDetailsPrincipal userDetailsPrincipal = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetailsPrincipal, null,userDetailsPrincipal.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }


    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }
    private String parseRefreshToken(HttpServletRequest request){
        String refreshHeaderAuth = request.getHeader("RefreshHeader");

        if (StringUtils.hasText(refreshHeaderAuth) && refreshHeaderAuth.startsWith("Bearer ")) {
            return refreshHeaderAuth.substring(7, refreshHeaderAuth.length());
        }

        return null;
    }
}
