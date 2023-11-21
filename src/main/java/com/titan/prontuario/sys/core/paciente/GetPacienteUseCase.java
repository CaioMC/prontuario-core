package com.titan.prontuario.sys.core.paciente;

import com.titan.prontuario.sys.core.paciente.domain.Paciente;
import com.titan.prontuario.sys.core.paciente.domain.enums.Sexo;
import com.titan.prontuario.sys.core.paciente.domain.enums.Uf;

import java.time.LocalDate;
import java.util.UUID;

public interface GetPacienteUseCase {

	GetPacienteProjetion handle(GetPacienteCommand cmd);

	record GetPacienteCommand(
			UUID id
	) {}

	record GetPacienteProjetion (
		UUID id,
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
	){
		public static GetPacienteProjetion toProjetion(Paciente paciente) {
			return new GetPacienteProjetion(
					paciente.getId(),
					paciente.getCodigo(),
					paciente.getNome(),
					paciente.getNascimento(),
					paciente.getSexo(),
					paciente.getEmail(),
					paciente.getCpf(),
					paciente.getRg(),
					paciente.getTelefone(),
					paciente.getTelefoneTrabalho(),
					paciente.getCep(),
					paciente.getEndereco(),
					paciente.getComplemento(),
					paciente.getCidade(),
					paciente.getPais(),
					paciente.getNumero(),
					paciente.getBairro(),
					paciente.getUf(),
					paciente.getConvenio(),
					paciente.getNumeroCarteirinha(),
					paciente.getAcomodacao(),
					paciente.getPlano(),
					paciente.getValidade()
			);
		}
	}
}
