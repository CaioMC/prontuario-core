package com.titan.prontuario.sys.core.paciente.domain;

import com.titan.prontuario.sys.core.paciente.IncluirPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.UpdatePacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.enums.Sexo;
import com.titan.prontuario.sys.core.paciente.domain.enums.Uf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Paciente - Dominio")
class PacienteTest {

	private static final String CODIGO = "7316";
	private static final String NOME = "Caio";
	private static final LocalDate DATA_NASCIMENTO = LocalDate.now();
	private static final Sexo SEXO = Sexo.MASCULINO;
	private static final String EMAIL = "caio@gmail.com";
	private static final String CPF = "98976456767";
	private static final String RG = "2902020202";
	private static final String CELULAR1 = "47996213534";
	private static final String CELULAR2 = "47996213538";
	private static final String CEP = "89221-009";
	private static final String ENDERECO = "endereco";
	private static final String COMPLEMENTO = "complemento";
	private static final String CIDADE = "cidade";
	private static final String PAIS = "pais";
	private static final int NUMERO = 123;
	private static final String BAIRRO = "bairro";
	private static final Uf UF = Uf.ACRE;
	private static final String CONVENIO = "convenio";
	private static final int NUMERO_CARTEIRINHA = 123441;
	private static final String ACOMODACAO = "acomodacao";
	private static final String PLANO = "plano";
	private static final LocalDate VALIDADE = LocalDate.now();

	@Test
	void testRegistrarPaciente() {
		IncluirPacienteUseCase.IncluirPacienteCommand incluirPacienteCommand = new IncluirPacienteUseCase.IncluirPacienteCommand(
				CODIGO,
				NOME,
				DATA_NASCIMENTO,
				SEXO,
				EMAIL,
				CPF,
				RG,
				CELULAR1,
				CELULAR2,
				CEP,
				ENDERECO,
				COMPLEMENTO,
				CIDADE,
				PAIS,
				NUMERO,
				BAIRRO,
				UF,
				CONVENIO,
				NUMERO_CARTEIRINHA,
				ACOMODACAO,
				PLANO,
				VALIDADE
		);

		var paciente = Paciente.registrarPaciente(incluirPacienteCommand);

		assertAll("Verifica se todos os atributos do paciente estão corretos",
				() -> assertEquals(CODIGO, paciente.getCodigo()),
				() -> assertEquals(NOME, paciente.getNome()),
				() -> assertEquals(DATA_NASCIMENTO, paciente.getNascimento()),
				() -> assertEquals(SEXO, paciente.getSexo()),
				() -> assertEquals(EMAIL, paciente.getEmail()),
				() -> assertEquals(CPF, paciente.getCpf()),
				() -> assertEquals(RG, paciente.getRg()),
				() -> assertEquals(CELULAR1, paciente.getTelefone()),
				() -> assertEquals(CELULAR2, paciente.getTelefoneTrabalho()),
				() -> assertEquals(CEP, paciente.getCep()),
				() -> assertEquals(ENDERECO, paciente.getEndereco()),
				() -> assertEquals(COMPLEMENTO, paciente.getComplemento()),
				() -> assertEquals(CIDADE, paciente.getCidade()),
				() -> assertEquals(PAIS, paciente.getPais()),
				() -> assertEquals(NUMERO, paciente.getNumero()),
				() -> assertEquals(BAIRRO, paciente.getBairro()),
				() -> assertEquals(UF, paciente.getUf()),
				() -> assertEquals(CONVENIO, paciente.getConvenio()),
				() -> assertEquals(NUMERO_CARTEIRINHA, paciente.getNumeroCarteirinha()),
				() -> assertEquals(ACOMODACAO, paciente.getAcomodacao()),
				() -> assertEquals(PLANO, paciente.getPlano()),
				() -> assertEquals(VALIDADE, paciente.getValidade())
		);
	}

	@Test
	void testUpdatePaciente() {
		UpdatePacienteUseCase.UpdatePacienteCommand updatePacienteCommand = new UpdatePacienteUseCase.UpdatePacienteCommand(
				UUID.randomUUID(),
				CODIGO,
				NOME,
				DATA_NASCIMENTO,
				SEXO,
				EMAIL,
				CPF,
				RG,
				CELULAR1,
				CELULAR2,
				CEP,
				ENDERECO,
				COMPLEMENTO,
				CIDADE,
				PAIS,
				NUMERO,
				BAIRRO,
				UF,
				CONVENIO,
				NUMERO_CARTEIRINHA,
				ACOMODACAO,
				PLANO,
				VALIDADE
		);



		Paciente paciente = Paciente.builder().build();

		paciente.updatePaciente(updatePacienteCommand);

		assertAll("Verifica se todos os atributos do paciente estão corretos",
				() -> assertEquals(CODIGO, paciente.getCodigo()),
				() -> assertEquals(NOME, paciente.getNome()),
				() -> assertEquals(DATA_NASCIMENTO, paciente.getNascimento()),
				() -> assertEquals(SEXO, paciente.getSexo()),
				() -> assertEquals(EMAIL, paciente.getEmail()),
				() -> assertEquals(CPF, paciente.getCpf()),
				() -> assertEquals(RG, paciente.getRg()),
				() -> assertEquals(CELULAR1, paciente.getTelefone()),
				() -> assertEquals(CELULAR2, paciente.getTelefoneTrabalho()),
				() -> assertEquals(CEP, paciente.getCep()),
				() -> assertEquals(ENDERECO, paciente.getEndereco()),
				() -> assertEquals(COMPLEMENTO, paciente.getComplemento()),
				() -> assertEquals(CIDADE, paciente.getCidade()),
				() -> assertEquals(PAIS, paciente.getPais()),
				() -> assertEquals(NUMERO, paciente.getNumero()),
				() -> assertEquals(BAIRRO, paciente.getBairro()),
				() -> assertEquals(UF, paciente.getUf()),
				() -> assertEquals(CONVENIO, paciente.getConvenio()),
				() -> assertEquals(NUMERO_CARTEIRINHA, paciente.getNumeroCarteirinha()),
				() -> assertEquals(ACOMODACAO, paciente.getAcomodacao()),
				() -> assertEquals(PLANO, paciente.getPlano()),
				() -> assertEquals(VALIDADE, paciente.getValidade())
		);
	}
}
