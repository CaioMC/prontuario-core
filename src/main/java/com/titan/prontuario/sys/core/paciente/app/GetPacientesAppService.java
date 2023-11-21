package com.titan.prontuario.sys.core.paciente.app;

import com.titan.prontuario.sys.core.paciente.GetPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class GetPacientesAppService implements GetPacienteUseCase {

	private final PacienteDomainRepository repository;

	@Override
	public GetPacienteProjetion handle(GetPacienteCommand cmd) {
		return GetPacienteProjetion.toProjetion(this.repository.findById(cmd.id()).orElseGet(null));
	}
}
