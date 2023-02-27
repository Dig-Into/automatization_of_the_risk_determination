package com.aord.aord.service.impl;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;

import com.aord.aord.model.JWT;
import com.aord.aord.model.AppUser;
import com.aord.aord.repository.JWTRepository;
import com.aord.aord.service.util.RandomStringBuilder;
import com.aord.aord.service.JWTService;
import com.aord.aord.service.exception.InvalidTokenException;
import com.aord.aord.constant.UserLoginConstants;

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
    public String createToken(AppUser user) {
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

        JWT token = new JWT();
        token.setUser(user);
        token.setValue(jti);
        token.setExpirationTime(Instant.now().plusMillis(tokenExpirationTime));

        jwtRepository.save(token);
        return jwt;
    }

    @Override
    public JWT validateJWTOrThrowException(String jwt) {
        return jwtRepository
                .findByValueAndExpirationTimeGreaterThanEqual(verifier.verify(jwt).getId(), Instant.now())
                .orElseThrow(() -> new InvalidTokenException(UserLoginConstants.INVALID_TOKEN_PROVIDED));
    }

    @Override
    public void deleteExpiredTokens() {
        //Should be added
    }

    @Override
    public void deleteAllByUser(AppUser user) {
        //Should be added
    }

    @Override
    public void deleteByValue(String token) {
        //Should be added
    }

    public void prolongExpirationTime(JWT jwt) {
        jwt.setExpirationTime(Instant.now().plusMillis(tokenExpirationTime));
        jwtRepository.save(jwt);
    }

}