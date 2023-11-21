package com.titan.prontuario.sys.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ProntuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProntuarioApplication.class, args);
	}

}