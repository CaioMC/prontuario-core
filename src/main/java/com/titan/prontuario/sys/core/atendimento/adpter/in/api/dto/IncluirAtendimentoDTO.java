package com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto;

import java.time.LocalDate;
import java.util.UUID;

public record IncluirAtendimentoDTO(
		String queixaPrincipal,
		String historicoAntecedentes,
		String exameFisico,
		String condutas,
		String diagnostico,
		LocalDate dataAtendimento,
		UUID pacienteId,
		UUID profissionalId
) {}
