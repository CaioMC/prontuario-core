package com.titan.prontuario.sys.core.atendimento.app;

import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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
class IncluirAtendimentoAppServiceTest {

	@InjectMocks
	private IncluirAtendimentoAppService incluirAtendimentoAppService;

	@Mock
	private AtendimentoDomainRepository repository;

	@Test
	void testIncluirAtendimentoSuccess() {
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

		assertDoesNotThrow(() -> this.incluirAtendimentoAppService.handle(incluirAtendimentoCommad));
	}
}
