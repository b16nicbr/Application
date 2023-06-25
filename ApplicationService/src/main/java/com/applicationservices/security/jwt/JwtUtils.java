package com.applicationservices.security.jwt;

import com.applicationservices.security.services.impl.UserDetailsPrincipalImpl;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${jwt.secret}")
    private String jwtsecret;
    @Value("${jwt.expirationDateInMs}")
    private int jwtExpirationInMs;
    @Value("${jwt.refreshExpirationDateInMs}")
    private int jwtRefreshTokenInMs;
    @Autowired
    UserDetailsPrincipalImpl userDetailsPrincipal;
    public String generateJwtToken(Authentication authentication){
        UserDetailsPrincipalImpl userPrincipal = (UserDetailsPrincipalImpl) authentication.getPrincipal();

        String jwtToken =  Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512, jwtsecret)
                .compact();
        logger.info("Token successfully generated: {}",jwtToken );
        return jwtToken;
    }

    public String refreshJwtToken(HttpServletRequest httpServletRequest, String token){

        if(httpServletRequest.getHeader("RefreshToken") == null) {
            String refeshedToken = Jwts.builder()
                    .setSubject(userDetailsPrincipal.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + jwtRefreshTokenInMs))
                    .signWith(SignatureAlgorithm.HS512, jwtsecret)
                    .compact();
            logger.info("refreshed Token successfully generated: {}", refeshedToken);
            return refeshedToken;
        }
        return "";
    }
    public boolean validateJwtToken(String jwt, String refreshToken,Boolean isRefreshToken) {
        try {
            Jwts.parser().setSigningKey(jwtsecret).parseClaimsJws(isRefreshToken ? refreshToken : jwt);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String getUserNameFromJwtToken(String jwt) {
        return Jwts.parser().setSigningKey(jwtsecret).parseClaimsJws(jwt).getBody().getSubject();
    }
}
