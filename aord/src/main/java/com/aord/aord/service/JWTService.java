package com.aord.aord.service;

import org.springframework.stereotype.Service;

import com.aord.aord.model.JWT;
import com.aord.aord.model.AppUser;

@Service
public interface JWTService {
    String createToken(AppUser user);
    JWT validateJWTOrThrowException(String jwt);
    void deleteExpiredTokens();
    void deleteAllByUser(AppUser user);
    void deleteByValue(final String token);
    void prolongExpirationTime(JWT jwt);

}