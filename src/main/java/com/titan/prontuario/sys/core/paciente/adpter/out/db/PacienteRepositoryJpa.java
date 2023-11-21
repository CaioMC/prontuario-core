package com.titan.prontuario.sys.core.paciente.adpter.out.db;

import com.titan.prontuario.sys.core.paciente.domain.Paciente;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface PacienteRepositoryJpa extends PacienteDomainRepository, Repository<Paciente, UUID> {
}
