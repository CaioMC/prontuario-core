package com.titan.prontuario.sys.core.atendimento.adpter.in.api;

import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.IncluirAtendimentoDTO;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.openapi.AtendimentoOpenApi;
import com.titan.prontuario.sys.core.paciente.adpter.in.api.PacienteController;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = PacienteController.PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(name = "Atendimento Controller")
public class AtendimentoController implements AtendimentoOpenApi {

	private final IncluirAtendimentoUseCase incluirAtendimentoUseCase;

	@PostMapping("/incluir-atendimento")
	public ResponseEntity<Void> incluirAtendimento(final @Valid @RequestBody IncluirAtendimentoDTO dto) {
		this.incluirAtendimentoUseCase.handle(IncluirAtendimentoUseCase.IncluirAtendimentoCommad.toCommand(dto));
		return ResponseEntity.ok().build();
	}
}
