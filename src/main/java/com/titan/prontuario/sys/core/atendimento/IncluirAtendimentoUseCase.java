package com.titan.prontuario.sys.core.atendimento;

import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.IncluirAtendimentoDTO;

import java.time.LocalDate;
import java.util.UUID;

public interface IncluirAtendimentoUseCase {

	void handle(IncluirAtendimentoCommad cmd);

	record IncluirAtendimentoCommad(
			String queixaPrincipal,
			String historicoAntecedentes,
			String exameFisico,
			String condutas,
			String diagnostico,
			LocalDate dataAtendimento,
			UUID pacienteId,
			UUID profissionalId
	){
		public static IncluirAtendimentoCommad toCommand(IncluirAtendimentoDTO dto) {
			return new IncluirAtendimentoCommad(
					dto.queixaPrincipal(),
					dto.historicoAntecedentes(),
					dto.exameFisico(),
					dto.condutas(),
					dto.diagnostico(),
					dto.dataAtendimento(),
					dto.pacienteId(),
					dto.profissionalId()
			);
		}
	}
}
