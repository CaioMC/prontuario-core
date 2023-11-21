package com.titan.prontuario.sys.core.atendimento.app;

import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.domain.Atendimento;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class IncluirAtendimentoAppService implements IncluirAtendimentoUseCase {

	private final AtendimentoDomainRepository repository;

	@Override
	public void handle(IncluirAtendimentoCommad cmd) {
		this.repository.save(Atendimento.incluirAtendimento(cmd));
	}
}
