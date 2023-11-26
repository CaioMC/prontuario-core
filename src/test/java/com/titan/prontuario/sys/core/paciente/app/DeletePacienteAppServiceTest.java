package com.titan.prontuario.sys.core.paciente.app;

import com.titan.prontuario.sys.core.paciente.DeletePacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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
class DeletePacienteAppServiceTest {

	@InjectMocks
	private DeletePacienteAppService deletePacienteAppService;

	@Mock
	private PacienteDomainRepository repository;

	@Test
	void testDeletePacienteSuccess() {
		var deletePacienteCommand = new DeletePacienteUseCase.DeletePacienteCommand(UUID.randomUUID());

		assertDoesNotThrow(() -> this.deletePacienteAppService.handle(deletePacienteCommand));
	}
}
