package com.titan.prontuario.sys.core.infra.config.security.config;

import com.titan.prontuario.sys.core.infra.config.security.app.JwtAppServive;
import com.titan.prontuario.sys.core.infra.config.security.filter.JwtAuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

	private final JwtAppServive jwtAppServive;

	public OncePerRequestFilter jwtFilter() {
		return new JwtAuthFilter(this.jwtAppServive);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
						(authz) ->
								authz
										.requestMatchers("api/v1/**").authenticated()
										.anyRequest().permitAll()
				)
				.csrf(AbstractHttpConfigurer::disable)
				.cors(withDefaults())
				.httpBasic(AbstractHttpConfigurer::disable)
				.sessionManagement(httpSecuritConfigurer -> httpSecuritConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(this.jwtFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}