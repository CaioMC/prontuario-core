package com.titan.prontuario.sys.core.atendimento.app;

import com.titan.prontuario.sys.core.atendimento.GetAllAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import com.titan.prontuario.sys.core.paciente.GetAllPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class GetAllAtendimentoAppService implements GetAllAtendimentoUseCase {

	private final AtendimentoDomainRepository repository;

	@Override
	public List<GetAllAtendimentoProjetion> handle(GetAllAtendimentoFilterCommand cmd) {
		return this.repository.getAllAtendimentos(
				cmd.nomePaciente(),
				cmd.queixaPrincipal(),
				cmd.diagnostico()
		);
	}
}
