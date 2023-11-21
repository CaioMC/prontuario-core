package com.titan.prontuario.sys.core.atendimento.app;

import com.titan.prontuario.sys.core.atendimento.UpdateAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UpdateAtendimentoAppService implements UpdateAtendimentoUseCase {

	private final AtendimentoDomainRepository repository;

	@Override
	public void handle(UpdateAtendimentoCommand cmd) {
		this.repository.findById(cmd.id()).ifPresent(
				atendimento -> this.repository.save(atendimento.updateAtendimento(cmd))
		);
	}
}
