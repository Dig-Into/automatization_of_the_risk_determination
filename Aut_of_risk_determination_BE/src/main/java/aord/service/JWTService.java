package aord.service;

import aord.model.JWT;
import aord.model.User;

public interface JWTService {
	String createToken(User user);

	JWT validateJWTOrThrowException(String jwt);

	void deleteExpiredTokens();

	void deleteAllByUser(User user);

	void deleteByValue(final String token);

	void prolongExpirationTime(JWT jwt);
}
