package aord.service.impl;

import java.time.Instant;
import java.util.Date;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import aord.model.JWT;
import aord.model.User;
import aord.repository.JWTRepository;
import aord.service.JWTService;
import aord.service.exception.InvalidTokenException;
import aord.service.exception.util.ExceptionMessages;
import aord.service.util.RandomStringBuilder;

@Service
public class JWTServiceImpl implements JWTService {

	private static final String ISSUER = "aord";
	private final JWTRepository jwtRepository;

	@Value("${access-token.expiration-time}")
	private long tokenExpirationTime;

	private String hmacSecret;

	private JWTVerifier verifier;

	@Autowired
	public JWTServiceImpl(JWTRepository jwtRepository, @Value("${hmac.secret}") final String hmacSecret) {
		this.jwtRepository = jwtRepository;
		Algorithm algorithm = Algorithm.HMAC512(hmacSecret);
		verifier = com.auth0.jwt.JWT.require(algorithm).withIssuer(ISSUER).build();
		this.hmacSecret = hmacSecret;
	}

	  @Override
	  public String createToken(User user) {
	    String jti = RandomStringBuilder.generateBase32String(32);
	    String jwt =
	        com.auth0
	            .jwt
	            .JWT
	            .create()
	            .withIssuer(ISSUER)
	            .withSubject(String.valueOf(user.getId()))
	            .withClaim("email", user.getEmail())
	            .withClaim("role", user.getUserRole().getName().toString())
	            .withIssuedAt(Date.from(Instant.now()))
	            .withJWTId(jti)
	            .sign(Algorithm.HMAC512(hmacSecret));

	    jwtRepository.save(
	        JWT.builder()
	            .user(user)
	            .value(jti)
	            .expirationTime(Instant.now().plusMillis(tokenExpirationTime))
	            .build());
	    return jwt;
	  }

	@Override
	public JWT validateJWTOrThrowException(String jwt) {
	    return jwtRepository
	            .findByValueAndExpirationTimeGreaterThanEqual(verifier.verify(jwt).getId(), Instant.now())
	            .orElseThrow(() -> new InvalidTokenException(ExceptionMessages.INVALID_TOKEN_PROVIDED));
	}

	@Override
	public void deleteExpiredTokens() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByValue(String token) {
		// TODO Auto-generated method stub

	}

	public void prolongExpirationTime(JWT jwt) {
		jwt.setExpirationTime(Instant.now().plusMillis(tokenExpirationTime));
		jwtRepository.save(jwt);
	}

}
