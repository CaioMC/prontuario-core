package com.titan.prontuario.sys.core.paciente.app;

import com.titan.prontuario.sys.core.paciente.UpdatePacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UpdatePacienteAppService implements UpdatePacienteUseCase {

	private final PacienteDomainRepository repository;

	@Override
	public void handle(UpdatePacienteCommand cmd) {
		this.repository.findById(cmd.id()).ifPresent(
				paciente -> paciente.updatePaciente(cmd));
	}
}
