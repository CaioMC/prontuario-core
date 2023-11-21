package com.titan.prontuario.sys.core.atendimento.adpter.in.api.openapi;

import com.titan.prontuario.sys.core.atendimento.GetAllAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.GetAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.IncluirAtendimentoDTO;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.UpdateAtendimentoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AtendimentoOpenApi {

	@Operation(description = "API responsável por incluir o atendimento no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Atendimento salvo com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de inclusão do atendimento inválida, não foi possível incluir o atendimento.")
	})
	ResponseEntity<Void> incluirAtendimento(final @RequestBody IncluirAtendimentoDTO dto);

	@Operation(description = "API responsável pegar informações de todos os atendimentos no sistema.", method = "GET")
	ResponseEntity<List<GetAllAtendimentoUseCase.GetAllAtendimentoProjetion>> getAllAtendimentos(
			@RequestParam(required = false) String nomePaciente,
			@RequestParam(required = false) String queixaPrincipal,
			@RequestParam(required = false) String diagnostico
	);

	@Operation(description = "API responsável pegar informações de todos os pacientes no sistema.", method = "GET")
	ResponseEntity<GetAtendimentoUseCase.GetAtendimentoProjetion> getAtendimento(@RequestParam(required = false) String id);

	@Operation(description = "API responsável por atualizar o atendimento no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Atendimento atualizado com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de atualização do atendimento inválida, não foi possível atualizar o atendimento.")
	})
	ResponseEntity<Void> updateAtendimento(final @RequestBody UpdateAtendimentoDTO dto);

	@Operation(description = "API responsável por deletar o atendimento no sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Atendimento deletado com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de deleção do atendimento inválida, não foi possível atualizar o atendimento.")
	})
	ResponseEntity<Void> deleteAtendimento(@RequestParam(required = false) String id);
}
