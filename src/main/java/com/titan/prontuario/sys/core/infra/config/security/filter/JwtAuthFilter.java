package com.titan.prontuario.sys.core.infra.config.security.filter;

import com.titan.prontuario.sys.core.infra.config.security.app.JwtAppServive;
import com.titan.prontuario.sys.core.infra.config.security.exception.TokenInvalidoException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtAppServive jwtAppServive;

	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {

		String authorization = request.getHeader("Authorization");
		if (authorization != null && authorization.startsWith("Bearer")) {

			String token = authorization.split(" ")[1];
			if (!this.jwtAppServive.tokenValido(token))
				throw new TokenInvalidoException();
		}

		filterChain.doFilter(request, response);
	}
}
