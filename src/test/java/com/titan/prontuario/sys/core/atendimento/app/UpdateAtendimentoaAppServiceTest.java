package com.titan.prontuario.sys.core.atendimento.app;

import com.titan.prontuario.sys.core.atendimento.UpdateAtendimentoUseCase;
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
class UpdateAtendimentoaAppServiceTest {

	@InjectMocks
	private UpdateAtendimentoAppService updateAtendimentoaAppService;

	@Mock
	private AtendimentoDomainRepository repository;

	@Test
	void testUpdateAtendimentoSuccess() {
		var updateAtendimentoCommand = new UpdateAtendimentoUseCase.UpdateAtendimentoCommand(
				UUID.randomUUID(),
				"dor de barriga",
				"pais com gastrite",
				"gastrite",
				null,
				"gastrite intermitente",
				LocalDate.now(),
				UUID.randomUUID(),
				UUID.randomUUID()
		);

		assertDoesNotThrow(() -> this.updateAtendimentoaAppService.handle(updateAtendimentoCommand));
	}
}
