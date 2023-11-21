package com.titan.prontuario.sys.core.paciente.adpter.out.db;

import com.titan.prontuario.sys.core.paciente.GetAllPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.Paciente;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PacienteRepositoryJpa extends PacienteDomainRepository, CrudRepository<Paciente, UUID> {

	@Query(value = """
			      SELECT p.id AS id, p.nome AS nome, p.telefone AS telefone, p.codigo AS codigo, a.data_atendimento as ultimaConsulta
			      FROM {h-schema}paciente p
			          LEFT JOIN {h-schema}atendimento a ON a.paciente_id = p.id
			      WHERE (:nome IS NULL OR p.nome ILIKE CONCAT('%', :nome, '%')) 
			      AND (:codigo IS NULL OR p.codigo ILIKE CONCAT('%', :codigo, '%'))
			""", nativeQuery = true)
	List<GetAllPacienteUseCase.GetAllPacientesProjetion> getAllPacientes(
			@Param("nome") String nome,
			@Param("codigo") String codigo);
}