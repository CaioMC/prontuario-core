package com.titan.prontuario.sys.core.paciente;

import java.util.UUID;

public interface DeletePacienteUseCase {

	void handle(DeletePacienteCommand cmd);


	record DeletePacienteCommand(
			UUID id
	) {
	}
}