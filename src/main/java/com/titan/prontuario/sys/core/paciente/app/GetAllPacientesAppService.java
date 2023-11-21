package com.titan.prontuario.sys.core.paciente.app;

import com.titan.prontuario.sys.core.paciente.GetAllPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class GetAllPacientesAppService implements GetAllPacienteUseCase {

	private final PacienteDomainRepository repository;

	@Override
	public List<GetAllPacientesProjetion> handle(GetAllPacientesFilterCommand cmd) {
		return this.repository.getAllPacientes(cmd.nome(), cmd.codigo());
	}
}
