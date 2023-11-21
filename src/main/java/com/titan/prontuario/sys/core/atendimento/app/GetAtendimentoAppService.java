package com.titan.prontuario.sys.core.atendimento.app;

import com.titan.prontuario.sys.core.atendimento.GetAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class GetAtendimentoAppService implements GetAtendimentoUseCase {

	private final AtendimentoDomainRepository repository;

	@Override
	public GetAtendimentoProjetion handle(GetAtendimentoCommand cmd) {
		return this.repository.getAtendimento(cmd.id());
	}
}
