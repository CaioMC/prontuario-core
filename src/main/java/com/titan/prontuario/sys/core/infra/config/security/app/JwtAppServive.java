package com.titan.prontuario.sys.core.infra.config.security.app;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class JwtAppServive {

	private static final String CHAVE_ASSINATURA = "aEkyQ1hTcnF1aXRNcGFYNW5Zcm9wVUc=";

	public boolean tokenValido(String token) {
		try {
			Claims claims = obterClaims(token);
			Date dataExpiracao = claims.getExpiration();
			LocalDateTime data =
					dataExpiracao.toInstant()
							.atZone(ZoneId.systemDefault()).toLocalDateTime();
			return !LocalDateTime.now().isAfter(data);
		} catch (Exception e) {
			return false;
		}
	}

	public static Claims obterClaims(String token) throws ExpiredJwtException {
		return Jwts
				.parser()
				.setSigningKey(CHAVE_ASSINATURA)
				.parseClaimsJws(token)
				.getBody();
	}
}