package com.titan.prontuario.sys.core.paciente.app;

import com.titan.prontuario.sys.core.paciente.IncluirPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.Paciente;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class IncluirPacienteAppService implements IncluirPacienteUseCase {

	private final PacienteDomainRepository repository;

	@Override
	public void handle(IncluirPacienteCommand cmd) {
		this.repository.save(Paciente.registrarPaciente(cmd));
	}
}
