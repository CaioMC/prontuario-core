package com.titan.prontuario.sys.core.paciente.adpter.in.api.openapi;

import com.titan.prontuario.sys.core.paciente.adpter.in.api.dto.IncluirPacienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface PacienteControllerOpenApi {

	@Operation(description = "API responsável por incluir o paciente no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Paciente salvo com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de inclusão do paciente inválida, não foi possível incluir o paciente.")
	})
	ResponseEntity<Void> incluirPaciente(final @Valid @RequestBody IncluirPacienteDTO dto);
}
