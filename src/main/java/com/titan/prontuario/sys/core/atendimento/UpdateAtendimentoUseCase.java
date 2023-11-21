package com.titan.prontuario.sys.core.atendimento;

import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.UpdateAtendimentoDTO;

import java.time.LocalDate;
import java.util.UUID;

public interface UpdateAtendimentoUseCase {

	void handle(UpdateAtendimentoCommand cmd);

	record UpdateAtendimentoCommand(
			UUID id,
			String queixaPrincipal,
			String historicoAntecedentes,
			String exameFisico,
			String condutas,
			String diagnostico,
			LocalDate dataAtendimento,
			UUID pacienteId,
			UUID profissionalId
	) {
		public static UpdateAtendimentoCommand toCommand(UpdateAtendimentoDTO dto) {
			return new UpdateAtendimentoCommand(
					UUID.fromString(dto.id()),
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
