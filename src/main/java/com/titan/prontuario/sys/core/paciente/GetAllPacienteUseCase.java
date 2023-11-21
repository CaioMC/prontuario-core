package com.titan.prontuario.sys.core.paciente;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface GetAllPacienteUseCase {

	List<GetAllPacientesProjetion> handle(GetAllPacientesFilterCommand cmd);

	record GetAllPacientesFilterCommand(
			String nome,
			String codigo
	) {
	}

	interface GetAllPacientesProjetion {
		UUID getId();
		String getNome();
		String getTelefone();
		String getCodigo();
		LocalDate getUltimaConsulta();
	}
}