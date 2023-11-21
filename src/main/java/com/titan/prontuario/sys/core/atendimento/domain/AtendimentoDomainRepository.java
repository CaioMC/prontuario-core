package com.titan.prontuario.sys.core.atendimento.domain;

import com.titan.prontuario.sys.core.atendimento.GetAllAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.GetAtendimentoUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AtendimentoDomainRepository {

	Atendimento save(Atendimento atendimento);

	List<GetAllAtendimentoUseCase.GetAllAtendimentoProjetion> getAllAtendimentos(
			String nomePaciente,
			String queixaPrincipal,
			String diagnostico
	);

	GetAtendimentoUseCase.GetAtendimentoProjetion getAtendimento(UUID id);

	void deleteByid(UUID id);

	Optional<Atendimento> findById(UUID id);
}
