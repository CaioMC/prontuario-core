package com.titan.prontuario.sys.core.atendimento.app;

import com.titan.prontuario.sys.core.atendimento.DeleteAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DeleteAtendimentoAppService implements DeleteAtendimentoUseCase {

	private final AtendimentoDomainRepository repository;

	@Override
	public void handle(DeleteAtendimentoCommand cmd) {
		this.repository.deleteByid(cmd.id());
	}
}
