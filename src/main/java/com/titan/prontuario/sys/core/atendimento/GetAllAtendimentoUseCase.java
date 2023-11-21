package com.titan.prontuario.sys.core.atendimento;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface GetAllAtendimentoUseCase {

	List<GetAllAtendimentoProjetion> handle(GetAllAtendimentoFilterCommand cmd);

	record GetAllAtendimentoFilterCommand(
			String nomePaciente,
			String queixaPrincipal,
			String diagnostico
	) {
	}

	interface GetAllAtendimentoProjetion {
		UUID getId();
		String getNomePaciente();
		String getQueixaPrincipal();
		String getCodigo();
		String getDiagnostico();
	}
}