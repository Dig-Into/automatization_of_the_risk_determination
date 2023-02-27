package com.aord.aord.security;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.aord.aord.model.JWT;
import com.aord.aord.model.AppUser;
import com.aord.aord.service.JWTService;
import com.aord.aord.service.UserService;
import com.aord.aord.constant.UserLoginConstants;

public class AuthorizationFilter extends GenericFilterBean{

    private static final String AUTH_HEADER_NAME = "Authorization";
    private static final String AUTH_SCHEME = "Bearer";

    private final JWTService jwtService;
    private final UserService userService;

    private static final Logger log = LoggerFactory.getLogger(AuthorizationFilter.class);

    public AuthorizationFilter(JWTService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestUrl = httpRequest.getRequestURL().toString();
        log.info("Request - {} {}", httpRequest.getMethod(), requestUrl);

        try {
            final String authHeader = httpRequest.getHeader(AUTH_HEADER_NAME);
            final String jwtToken = extractJwtFromAuthorizationHeader(authHeader);

            log.info("Jwt from request is {}", jwtToken);

            JWT jwt = jwtService.validateJWTOrThrowException(jwtToken);
            AppUser user = userService.findByIdOrThrowException(jwt.getUser().getId());
            UserAuthentication userAuth = new UserAuthentication(user, jwt.getValue());
            SecurityContextHolder.getContext().setAuthentication(userAuth);
            jwtService.prolongExpirationTime(jwt);

            chain.doFilter(request, response);
        } catch (Exception ex) {
            logger.error(UserLoginConstants.INVALID_TOKEN_PROVIDED);
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    private String extractJwtFromAuthorizationHeader(final String authHeader) {
        final String[] authHeaderParts = authHeader.split(" ");
        return AUTH_SCHEME.equals(authHeaderParts[0]) ? authHeaderParts[1] : null;
    }
}