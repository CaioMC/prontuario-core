package com.titan.prontuario.sys.core.paciente.domain;

import com.titan.prontuario.sys.core.paciente.GetAllPacienteUseCase;

import java.util.List;

public interface PacienteDomainRepository {

	Paciente save(Paciente paciente);

	List<GetAllPacienteUseCase.GetAllPacientesProjetion> getAllPacientes(String nome, String codigo);
}
