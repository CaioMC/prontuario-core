package com.titan.prontuario.sys.core.atendimento.adpter.out.db;

import com.titan.prontuario.sys.core.atendimento.GetAllAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.domain.Atendimento;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AtendimentoRepositoryJpa extends AtendimentoDomainRepository, Repository<Atendimento, UUID> {

	@Query(value = """
        SELECT a.id AS id, p.nome AS nomePaciente, a.queixa_principal AS queixaPrincipal, p.codigo AS codigo, a.diagnostico AS diagnostico
        FROM {h-schema}atendimento a
            LEFT JOIN {h-schema}paciente p ON (:nomePaciente IS NULL OR p.nome ILIKE CONCAT('%', :nomePaciente, '%'))
        WHERE (:queixaPrincipal IS NULL OR a.queixa_principal ILIKE CONCAT('%', :queixaPrincipal, '%'))
        AND (:diagnostico IS NULL OR a.diagnostico ILIKE CONCAT('%', :diagnostico, '%'))
		""", nativeQuery = true)
	List<GetAllAtendimentoUseCase.GetAllAtendimentoProjetion> getAllAtendimentos(
			@Param("nomePaciente") String nomePaciente,
			@Param("queixaPrincipal") String queixaPrincipal,
			@Param("diagnostico") String diagnostico
	);

}
