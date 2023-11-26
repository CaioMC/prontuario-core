package com.titan.prontuario.sys.core.atendimento.usecase;

import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@ActiveProfiles("it")
class IncluirAtendimentoUseCaseTest {

	@Mock
	private IncluirAtendimentoUseCase incluirAtendimentoUseCase;

	@Test
	void testIncluirAtendimentoSuccess(){
		var incluirAtendimentoCommad = new IncluirAtendimentoUseCase.IncluirAtendimentoCommad(
				"dor de barriga",
				"pais com gastrite",
				"gastrite",
				null,
				"gastrite intermitente",
				LocalDate.now(),
				UUID.randomUUID(),
				UUID.randomUUID()
		);

		assertDoesNotThrow(() -> this.incluirAtendimentoUseCase.handle(incluirAtendimentoCommad));
	}

}
