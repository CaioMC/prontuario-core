package com.titan.prontuario.sys.core.paciente.app;

import com.titan.prontuario.sys.core.paciente.DeletePacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DeletePacienteAppService implements DeletePacienteUseCase {

	private final PacienteDomainRepository repository;

	@Override
	public void handle(DeletePacienteCommand cmd) {
		this.repository.deleteByid(cmd.id());
	}
}
