package com.titan.prontuario.sys.core.paciente.adpter.in.api.dto;

import com.titan.prontuario.sys.core.paciente.domain.enums.Sexo;
import com.titan.prontuario.sys.core.paciente.domain.enums.Uf;

import java.time.LocalDate;

public record UpdatePacienteDTO(
		String id,
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
) {}
