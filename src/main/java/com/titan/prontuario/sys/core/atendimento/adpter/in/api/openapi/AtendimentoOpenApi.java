package com.titan.prontuario.sys.core.atendimento.adpter.in.api.openapi;

import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.IncluirAtendimentoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AtendimentoOpenApi {

	@Operation(description = "API responsável por incluir o atendimento no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Atendimento salvo com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de inclusão do atendimento inválida, não foi possível incluir o atendimento.")
	})
	ResponseEntity<Void> incluirAtendimento(final @Valid @RequestBody IncluirAtendimentoDTO dto);
}
