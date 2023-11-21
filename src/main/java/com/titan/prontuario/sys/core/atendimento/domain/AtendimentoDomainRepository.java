package com.titan.prontuario.sys.core.atendimento.domain;

import com.titan.prontuario.sys.core.atendimento.GetAllAtendimentoUseCase;

import java.util.List;

public interface AtendimentoDomainRepository {

	Atendimento save(Atendimento atendimento);

	List<GetAllAtendimentoUseCase.GetAllAtendimentoProjetion> getAllAtendimentos(
			String nomePaciente,
			String queixaPrincipal,
			String diagnostico
	);

}
