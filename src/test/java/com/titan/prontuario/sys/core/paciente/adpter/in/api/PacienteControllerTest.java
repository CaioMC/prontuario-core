package com.titan.prontuario.sys.core.paciente.adpter.in.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.titan.prontuario.sys.core.paciente.IncluirPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.adpter.in.api.dto.IncluirPacienteDTO;
import com.titan.prontuario.sys.core.paciente.adpter.in.api.dto.UpdatePacienteDTO;
import com.titan.prontuario.sys.core.paciente.domain.Paciente;
import com.titan.prontuario.sys.core.paciente.domain.PacienteDomainRepository;
import com.titan.prontuario.sys.core.paciente.domain.enums.Sexo;
import com.titan.prontuario.sys.core.paciente.domain.enums.Uf;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@ActiveProfiles("it")
class PacienteControllerTest {

	@InjectMocks
	private PacienteController pacienteController;

	@Mock
	private PacienteDomainRepository repository;

	@Autowired
	private MockMvc mock;

	@Autowired
	ObjectMapper mapper;

	@Test
	void testIncluirPacienteSuccess() throws Exception {
		IncluirPacienteDTO incluirPacienteDTO = new IncluirPacienteDTO(
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

		String dto = mapper.writeValueAsString(incluirPacienteDTO);

		mock.perform(post("/api/paciente/incluir-paciente")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dto))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void testUpdatePacienteSuccess() throws Exception {
		UpdatePacienteDTO updatePacienteDTO = new UpdatePacienteDTO(
				"7f97bc90-c3cb-4c33-a5d0-1a755714b047",
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

		String dto = mapper.writeValueAsString(updatePacienteDTO);

		mock.perform(post("/api/paciente/incluir-paciente")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dto))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void testDeletePacienteSuccess() throws Exception {
		var IncluirPacienteCommand = new IncluirPacienteUseCase.IncluirPacienteCommand(
				"7316",
				"Marcos",
				LocalDate.now(),
				Sexo.MASCULINO,
				"marcos@gmail.com",
				"88976456769",
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

		var paciente = Paciente.registrarPaciente(IncluirPacienteCommand);

		this.repository.save(paciente);

		mock.perform(post("/api/paciente/delete-paciente")
						.contentType(MediaType.APPLICATION_JSON)
						.param("id", paciente.getId().toString()))
				.andExpect(status().isOk())
				.andReturn();
	}
}