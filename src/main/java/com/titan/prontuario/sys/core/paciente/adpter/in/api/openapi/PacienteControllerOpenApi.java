package com.titan.prontuario.sys.core.paciente.adpter.in.api.openapi;

import com.titan.prontuario.sys.core.paciente.GetAllPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.GetPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.adpter.in.api.dto.IncluirPacienteDTO;
import com.titan.prontuario.sys.core.paciente.adpter.in.api.dto.UpdatePacienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PacienteControllerOpenApi {

	@Operation(description = "API responsável por incluir o paciente no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Paciente salvo com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de inclusão do paciente inválida, não foi possível incluir o paciente.")
	})
	ResponseEntity<Void> incluirPaciente(final @RequestBody IncluirPacienteDTO dto);

	@Operation(description = "API responsável pegar informações de todos os pacientes no sistema.", method = "GET")
	ResponseEntity<List<GetAllPacienteUseCase.GetAllPacientesProjetion>> getAllPacientes(
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String codigo
	);

	@Operation(description = "API responsável pegar informações do pacientes no sistema.", method = "GET")
	ResponseEntity<GetPacienteUseCase.GetPacienteProjetion> getPaciente(@RequestParam(required = false) String id);

	@Operation(description = "API responsável por atualizar o paciente no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Paciente salvo com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de atualização do paciente inválida, não foi possível atualizar o paciente.")
	})
	ResponseEntity<Void> updatePaciente(final @RequestBody UpdatePacienteDTO dto);

	@Operation(description = "API responsável por deletar o paciente no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Paciente deletado com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de deleção do paciente inválida, não foi possível atualizar o paciente.")
	})
	ResponseEntity<Void> deletePaciente(@RequestParam(required = false) String id);
}
