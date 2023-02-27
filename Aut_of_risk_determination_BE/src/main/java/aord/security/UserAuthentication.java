package aord.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import aord.model.User;
import aord.service.impl.UserServiceImpl;

public class UserAuthentication implements Authentication {
	
	private final User user;
	private final String token;

	private boolean authenticated = true;

	public UserAuthentication(User user, String token) {
		this.user = user;
		this.token = token;
	}

	@Override
	public String getName() {
		return user.getEmail();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return UserServiceImpl.getAuthorities(user.getUserRole().getName());
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getDetails() {
		return user;
	}

	@Override
	public Object getPrincipal() {
		return user.getEmail();
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated = isAuthenticated;

	}

	public String getToken() {
		return token;
	}

	public User getUser() {
		return user;
	}

}
