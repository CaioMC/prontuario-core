package com.titan.prontuario.sys.core.paciente.domain;

import com.titan.prontuario.sys.core.paciente.GetAllPacienteUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteDomainRepository {

	Paciente save(Paciente paciente);

	List<GetAllPacienteUseCase.GetAllPacientesProjetion> getAllPacientes(String nome, String codigo);

	void deleteByid(UUID uuid);

	Optional<Paciente> findById(UUID id);
}
