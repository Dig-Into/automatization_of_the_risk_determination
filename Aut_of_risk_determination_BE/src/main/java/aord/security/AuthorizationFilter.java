package aord.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import aord.model.JWT;
import aord.model.User;
import aord.service.UserService;
import aord.service.exception.util.ExceptionMessages;
import aord.service.JWTService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorizationFilter extends GenericFilterBean {

	private static final String AUTH_HEADER_NAME = "Authorization";
	private static final String AUTH_SCHEME = "Bearer";

	private final JWTService jwtService;
	private final UserService userService;

	public AuthorizationFilter(JWTService jwtService, UserService userService) {
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		log.info("Request - {} {}", httpRequest.getMethod(), httpRequest.getRequestURL().toString());

		try {
			final String authHeader = httpRequest.getHeader(AUTH_HEADER_NAME);
			final String jwtToken = extractJwtFromAuthorizationHeader(authHeader);

			log.info("Jwt from request is {}", jwtToken);

			JWT jwt = jwtService.validateJWTOrThrowException(jwtToken);
			User user = userService.findByIdOrThrowException(jwt.getUser().getId());
			UserAuthentication userAuth = new UserAuthentication(user, jwt.getValue());
			SecurityContextHolder.getContext().setAuthentication(userAuth);
			jwtService.prolongExpirationTime(jwt);

			chain.doFilter(request, response);
		} catch (Exception ex) {
			logger.error(ExceptionMessages.INVALID_TOKEN_PROVIDED);
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}

	}

	private String extractJwtFromAuthorizationHeader(final String authHeader) {
		final String[] authHeaderParts = authHeader.split(" ");
		return AUTH_SCHEME.equals(authHeaderParts[0]) ? authHeaderParts[1] : null;
	}

}
