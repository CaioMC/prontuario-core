package com.titan.prontuario.sys.core.paciente;

import com.titan.prontuario.sys.core.paciente.adpter.in.api.dto.IncluirPacienteDTO;
import com.titan.prontuario.sys.core.paciente.domain.enums.Sexo;
import com.titan.prontuario.sys.core.paciente.domain.enums.Uf;

import java.time.LocalDate;

public interface IncluirPacienteUseCase {

	void handle(IncluirPacienteCommand cmd);

	record IncluirPacienteCommand(
			String codigo,
			String nome,
			LocalDate nascimento,
			Sexo sexo,
			String email,
			String cpf,
			String rg,
			String telefone,
			String telefoneTrabalho,

			String cep,
			String endereco,
			String complemento,
			String cidade,
			String pais,
			int numero,
			String bairro,
			Uf uf,

			String convenio,
			int numeroCarteirinha,
			String acomodacao,
			String plano,
			LocalDate validade
	) {
		public static IncluirPacienteCommand toCommand(IncluirPacienteDTO dto) {
			return new IncluirPacienteCommand(
					dto.codigo(),
					dto.nome(),
					dto.nascimento(),
					dto.sexo(),
					dto.email(),
					dto.cpf(),
					dto.rg(),
					dto.telefone(),
					dto.telefoneTrabalho(),
					dto.cep(),
					dto.endereco(),
					dto.complemento(),
					dto.cidade(),
					dto.pais(),
					dto.numero(),
					dto.bairro(),
					dto.uf(),
					dto.convenio(),
					dto.numeroCarteirinha(),
					dto.acomodacao(),
					dto.plano(),
					dto.validade()
			);
		}
	}
}
