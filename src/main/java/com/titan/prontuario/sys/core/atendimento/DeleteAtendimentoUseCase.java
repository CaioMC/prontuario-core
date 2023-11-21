package com.titan.prontuario.sys.core.atendimento;

import java.util.UUID;

public interface DeleteAtendimentoUseCase {

	void handle(DeleteAtendimentoCommand cmd);


	record DeleteAtendimentoCommand(
			UUID id
	) {
	}
}