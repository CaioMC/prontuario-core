package com.titan.prontuario.sys.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Application.")
class ProntuarioApplicationTest {

	@Test
	@DisplayName("Application - Subir aplicação profiler test.")
	void contextLoads() {
		ProntuarioApplication.main(new String[]{"--spring.profiles.active=it"});
		Boolean aTrue = Boolean.TRUE;
		assertTrue(aTrue);
	}
}
