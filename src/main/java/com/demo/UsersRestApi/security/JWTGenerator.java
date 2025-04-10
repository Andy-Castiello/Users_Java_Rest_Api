package com.demo.UsersRestApi.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {

	public String generateToken(Authentication authentication) {

		String username = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

		String token = Jwts
							.builder()
								.setSubject(username)
								.setIssuedAt(currentDate)
								.setExpiration(expireDate)
								.signWith(SecurityConstants.JWT_SECRET, SignatureAlgorithm.HS512)
								.compact();

		return token;
	}

	public String getUsernameFromJWT(String token) {

		Claims claims = Jwts
							.parserBuilder()
								.setSigningKey(SecurityConstants.JWT_SECRET)
								.build()
								.parseClaimsJws(token)
								.getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String token) {

		try {
			Jwts.parserBuilder().setSigningKey(SecurityConstants.JWT_SECRET).build().parseClaimsJws(token);
			return true;

		} catch (Exception e) {
			throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect!");
		}
	}
}
