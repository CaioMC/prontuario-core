package com.titan.prontuario.sys.core.atendimento;

import java.time.LocalDate;
import java.util.UUID;

public interface GetAtendimentoUseCase {

	GetAtendimentoProjetion handle(GetAtendimentoCommand cmd);

	record GetAtendimentoCommand(
			UUID id
	) {}

	interface GetAtendimentoProjetion{
		String getId();
		String getQueixaPrincipal();
		String getHistoricoAntecedentes();
		String getExameFisico();
		String getCondutas();
		String getDiagnostico();
		LocalDate getDataAtendimento();
		String getpacienteNome();
	}
}
