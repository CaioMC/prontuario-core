package com.titan.prontuario.sys.core.paciente.domain;

import com.titan.prontuario.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import com.titan.prontuario.sys.core.paciente.IncluirPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.enums.Sexo;
import com.titan.prontuario.sys.core.paciente.domain.enums.Uf;
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
@Entity(name = "paciente")
public class Paciente extends AbstractAuditableAggregate {

	@Id
	private UUID id;
	private String codigo;
	private String nome;
	private LocalDate nascimento;
	private Sexo sexo;
	private String email;
	private String cpf;
	private String rg;

	private String telefone;
	private String telefoneTrabalho;

	private String cep;
	private String endereco;
	private String complemento;
	private String cidade;
	private String pais;
	private int numero;
	private String bairro;
	private Uf uf;

	private String convenio;
	private int numeroCarteirinha;
	private String acomodacao;
	private String plano;
	private LocalDate validade;
	
	public static Paciente registrarPaciente(IncluirPacienteUseCase.IncluirPacienteCommand cmd) {
		return new Paciente(
				UUID.randomUUID(),
				cmd.codigo(),
				cmd.nome(),
				cmd.nascimento(),
				cmd.sexo(),
				cmd.email(),
				cmd.cpf(),
				cmd.rg(),
				cmd.telefone(),
				cmd.telefoneTrabalho(),
				cmd.cep(),
				cmd.endereco(),
				cmd.complemento(),
				cmd.cidade(),
				cmd.pais(),
				cmd.numero(),
				cmd.bairro(),
				cmd.uf(),
				cmd.convenio(),
				cmd.numeroCarteirinha(),
				cmd.acomodacao(),
				cmd.plano(),
				cmd.validade()
		);
	}

}
