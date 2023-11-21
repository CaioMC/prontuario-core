package com.titan.prontuario.sys.core.infra.config.security.exception;

public class TokenInvalidoException extends RuntimeException {

    private static final long serialVersionUID = -5560171943682302666L;

    public TokenInvalidoException() {
        super("A autenticação realizada no sistema esta inválida.");
    }
}
