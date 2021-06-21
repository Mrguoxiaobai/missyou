package com.lin.missyou.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * The type Jwt token.
 *
 * @ClassName: com.lin.missyou.utils
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/17
 * @Version: 1.0
 */
@Component
public class JwtToken {

    private static String jwtKey;
    private static Integer expiredTimeIn;
    private static Integer defaultScope=8;

    /**
     * Set token key.
     *
     * @param jwtKey the jwt key
     */
    @Value("${missyou.security.jwt-key}")
    public void setTokenKey(String jwtKey){
        JwtToken.jwtKey=jwtKey;
    }

    /**
     * Set expired time.
     *
     * @param expiredTimeIn the expired time in
     */
    @Value("${missyou.security.token-expired-in}")
    public void setExpiredTime(Integer expiredTimeIn){
        JwtToken.expiredTimeIn=expiredTimeIn;
    }

    /**
     * Get claims optional.
     *
     * @param token the token
     * @return the optional
     */
    public static Optional<Map<String, Claim>> getClaims(String token){
        DecodedJWT decodedJWT;
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            decodedJWT = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
        return Optional.of(decodedJWT.getClaims());
    }

    /**
     * Make token string.
     *
     * @param uid   the uid
     * @param scope the scope
     * @return the string
     */
    public static String makeToken(Long uid ,Integer scope){
        return JwtToken.getToken(uid,scope);
    }

    /**
     * Make token string.
     *
     * @param uid the uid
     * @return the string
     */
    public static String makeToken(Long uid) {
        return JwtToken.getToken(uid, JwtToken.defaultScope);
    }

    /**
     * Get token string.
     *
     * @param uid   the uid
     * @param scope the scope
     * @return the string
     */
    public static String getToken(Long uid,Integer scope){
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        Map<String, Date> map = JwtToken.calculateExpiredIssues();

        return JWT.create()
                .withClaim("uid",uid)
                .withClaim("scope",scope)
                .withExpiresAt(map.get("expiredTime"))
                .withIssuedAt(map.get("now"))
                .sign(algorithm);
    }

    /**
     * Verify token boolean.
     *
     * @param token the token
     * @return the boolean
     */
    public static Boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

    private static Map<String, Date> calculateExpiredIssues() {
        Map<String, Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, JwtToken.expiredTimeIn);
        map.put("now", now);
        map.put("expiredTime", calendar.getTime());
        return map;
    }
}
