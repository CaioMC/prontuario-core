package com.titan.prontuario.sys.core.atendimento.adpter.in.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.IncluirAtendimentoDTO;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.UpdateAtendimentoDTO;
import com.titan.prontuario.sys.core.atendimento.domain.Atendimento;
import com.titan.prontuario.sys.core.atendimento.domain.AtendimentoDomainRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@ActiveProfiles("it")
class AtendimentoControllerTest {

	@InjectMocks
	private AtendimentoControllerTest atendimentoControllerTest;

	@Mock
	private AtendimentoDomainRepository repository;

	@Autowired
	private MockMvc mock;

	@Autowired
	ObjectMapper mapper;

	@Test
	void testIncluirAtendimentoSuccess() throws Exception {
		IncluirAtendimentoDTO incluirAtendimentoDTO = new IncluirAtendimentoDTO(
				"dor de barriga",
				"pais com gastrite",
				"gastrite",
				null,
				"gastrite intermitente",
				LocalDate.now(),
				UUID.randomUUID(),
				UUID.randomUUID()
		);

		String dto = mapper.writeValueAsString(incluirAtendimentoDTO);

		mock.perform(post("/api/atendimento/incluir-atendimento")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dto))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void testUpdateAtendimentoSuccess() throws Exception {
		var atendimentoCommad = new IncluirAtendimentoUseCase.IncluirAtendimentoCommad(
				"dor de barriga",
				"pais com gastrite",
				"gastrite",
				null,
				"gastrite intermitente",
				LocalDate.now(),
				UUID.randomUUID(),
				UUID.randomUUID()
		);


		var atendimento = Atendimento.incluirAtendimento(atendimentoCommad);

		this.repository.save(atendimento);

		UpdateAtendimentoDTO updateAtendimentoDTO = new UpdateAtendimentoDTO(
				atendimento.getId().toString(),
				"dor de barriga",
				"pais com gastrite",
				"gastrite",
				null,
				"gastrite intermitente",
				LocalDate.now(),
				UUID.randomUUID(),
				UUID.randomUUID()
		);

		String dto = mapper.writeValueAsString(updateAtendimentoDTO);

		mock.perform(post("/api/atendimento/update-atendimento")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dto))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void testDeletePacienteSuccess() throws Exception {
		var atendimentoCommad = new IncluirAtendimentoUseCase.IncluirAtendimentoCommad(
				"dor de barriga",
				"pais com gastrite",
				"gastrite",
				null,
				"gastrite intermitente",
				LocalDate.now(),
				UUID.randomUUID(),
				UUID.randomUUID()
		);


		var atendimento = Atendimento.incluirAtendimento(atendimentoCommad);

		this.repository.save(atendimento);

		mock.perform(post("/api/atendimento/delete-atendimento")
						.contentType(MediaType.APPLICATION_JSON)
						.param("id", atendimento.getId().toString())
				)
				.andExpect(status().isOk())
				.andReturn();
	}
}