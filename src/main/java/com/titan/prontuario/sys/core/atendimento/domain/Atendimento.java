package com.titan.prontuario.sys.core.atendimento.domain;

import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import com.titan.prontuario.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "atendimento")
public class Atendimento extends AbstractAuditableAggregate {

	@Id
	private UUID id;
	private String queixaPrincipal;
	private String historicoAntecedentes;
	private String exameFisico;
	private String condutas;
	private String diagnostico;
	private LocalDate dataAtendimento;
	private UUID pacienteId;
	private UUID profissionalId;
	
	public static Atendimento incluirAtendimento(IncluirAtendimentoUseCase.IncluirAtendimentoCommad cmd) {
		return new Atendimento(
				UUID.randomUUID(),
				cmd.queixaPrincipal(),
				cmd.historicoAntecedentes(),
				cmd.exameFisico(),
				cmd.condutas(),
				cmd.diagnostico(),
				cmd.dataAtendimento(),
				cmd.pacienteId(),
				cmd.profissionalId()
		);
	}

}
