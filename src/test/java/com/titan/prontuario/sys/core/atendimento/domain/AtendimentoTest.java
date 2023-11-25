package com.titan.prontuario.sys.core.atendimento.domain;

import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Atendimento - Dominio")
class AtendimentoTest {

	public static final String DOR_DE_BARRIGA = "dor de barriga";
	public static final String PAIS_COM_GASTRITE = "pais com gastrite";
	public static final String GASTRITE = "gastrite";
	public static final String GASTRITE_INTERMITENTE = "gastrite intermitente";
	public static final LocalDate DATA_ATENDIMENTO = LocalDate.now();
	public static final UUID PACIENTE_ID = UUID.randomUUID();
	public static final UUID PROFISSIONAL_ID = UUID.randomUUID();

	@Test
	void testIncluirAtendimento() {
		IncluirAtendimentoUseCase.IncluirAtendimentoCommad atendimentoCommad = new IncluirAtendimentoUseCase.IncluirAtendimentoCommad(
				DOR_DE_BARRIGA,
				PAIS_COM_GASTRITE,
				GASTRITE,
				null,
				GASTRITE_INTERMITENTE,
				DATA_ATENDIMENTO,
				PACIENTE_ID,
				PROFISSIONAL_ID
		);

		var atendimento = Atendimento.incluirAtendimento(atendimentoCommad);

		assertAll("Verifica se todos os atributos do atencimento estão corretos",
				() -> assertEquals(DOR_DE_BARRIGA, atendimento.getQueixaPrincipal()),
				() -> assertEquals(PAIS_COM_GASTRITE, atendimento.getHistoricoAntecedentes()),
				() -> assertEquals(GASTRITE, atendimento.getExameFisico()),
				() -> assertEquals(GASTRITE_INTERMITENTE, atendimento.getDiagnostico()),
				() -> assertEquals(DATA_ATENDIMENTO, atendimento.getDataAtendimento()),
				() -> assertEquals(PACIENTE_ID, atendimento.getPacienteId()),
				() -> assertEquals(PROFISSIONAL_ID, atendimento.getProfissionalId())
		);
	}

	@Test
	void testUpdateAtendimento() {
		IncluirAtendimentoUseCase.IncluirAtendimentoCommad atendimentoCommad = new IncluirAtendimentoUseCase.IncluirAtendimentoCommad(
				DOR_DE_BARRIGA,
				PAIS_COM_GASTRITE,
				GASTRITE,
				null,
				GASTRITE_INTERMITENTE,
				DATA_ATENDIMENTO,
				PACIENTE_ID,
				PROFISSIONAL_ID
		);

		var atendimento = Atendimento.incluirAtendimento(atendimentoCommad);

		assertAll("Verifica se todos os atributos do atencimento estão corretos",
				() -> assertEquals(DOR_DE_BARRIGA, atendimento.getQueixaPrincipal()),
				() -> assertEquals(PAIS_COM_GASTRITE, atendimento.getHistoricoAntecedentes()),
				() -> assertEquals(GASTRITE, atendimento.getExameFisico()),
				() -> assertEquals(GASTRITE_INTERMITENTE, atendimento.getDiagnostico()),
				() -> assertEquals(DATA_ATENDIMENTO, atendimento.getDataAtendimento()),
				() -> assertEquals(PACIENTE_ID, atendimento.getPacienteId()),
				() -> assertEquals(PROFISSIONAL_ID, atendimento.getProfissionalId())
		);
	}
}
