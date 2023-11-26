package com.titan.prontuario.sys.core.atendimento.usecase;

import com.titan.prontuario.sys.core.atendimento.DeleteAtendimentoUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@ActiveProfiles("it")
class DeleteAtendimentoUseCaseTest {

	@Mock
	private DeleteAtendimentoUseCase deleteAtendimentoUseCase;

	@Test
	void testUpdateAtendimentoSuccess(){
		var deleteAtendimentoCommad = new DeleteAtendimentoUseCase.DeleteAtendimentoCommand(UUID.randomUUID());

		assertDoesNotThrow(() -> this.deleteAtendimentoUseCase.handle(deleteAtendimentoCommad));
	}
}
