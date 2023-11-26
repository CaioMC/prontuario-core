package com.titan.prontuario.sys.core.paciente.usecase;

import com.titan.prontuario.sys.core.paciente.IncluirPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.domain.enums.Sexo;
import com.titan.prontuario.sys.core.paciente.domain.enums.Uf;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@ActiveProfiles("it")
class IncluirPacienteUseCaseTest {

	@Mock
	private IncluirPacienteUseCase incluirAtendimentoUseCase;

	@Test
	void testIncluirAtendimentoSuccess(){
		var incluirAtendimentoCommad = new IncluirPacienteUseCase.IncluirPacienteCommand(
				"7316",
				"Caio",
				LocalDate.now(),
				Sexo.MASCULINO,
				"caio@gmail.com",
				"98976456767",
				"2902020202",
				"47996213534",
				"47996213538",
				"89221-009",
				"endereco",
				"complemento",
				"cidade",
				"pais",
				123,
				"bairro",
				Uf.ACRE,
				"converio",
				123441,
				"acomodacao",
				"plano",
				LocalDate.now()
		);

		assertDoesNotThrow(() -> this.incluirAtendimentoUseCase.handle(incluirAtendimentoCommad));
	}
}
