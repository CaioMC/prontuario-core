package com.titan.prontuario.sys.core.atendimento.adpter.in.api;

import com.titan.prontuario.sys.core.atendimento.DeleteAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.GetAllAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.GetAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.IncluirAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.UpdateAtendimentoUseCase;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.IncluirAtendimentoDTO;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.dto.UpdateAtendimentoDTO;
import com.titan.prontuario.sys.core.atendimento.adpter.in.api.openapi.AtendimentoOpenApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = AtendimentoController.PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(name = "Atendimento Controller")
public class AtendimentoController implements AtendimentoOpenApi {

	public static final String PATH = "api/atendimento";

	private final IncluirAtendimentoUseCase incluirAtendimentoUseCase;
	private final GetAllAtendimentoUseCase getAllAtendimentoUseCase;
	private final GetAtendimentoUseCase getAtendimentoUseCase;
	private final UpdateAtendimentoUseCase updateAtendimentoUseCase;
	private final DeleteAtendimentoUseCase deleteAtendimentoUseCase;

	@PostMapping("/incluir-atendimento")
	public ResponseEntity<Void> incluirAtendimento(final @RequestBody IncluirAtendimentoDTO dto) {
		this.incluirAtendimentoUseCase.handle(IncluirAtendimentoUseCase.IncluirAtendimentoCommad.toCommand(dto));
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getAll-atendimento")
	public ResponseEntity<List<GetAllAtendimentoUseCase.GetAllAtendimentoProjetion>> getAllAtendimentos(
			@RequestParam(required = false) String nomePaciente,
			@RequestParam(required = false) String queixaPrincipal,
			@RequestParam(required = false) String diagnostico) {
		return ResponseEntity.ok(this.getAllAtendimentoUseCase.handle(new GetAllAtendimentoUseCase.GetAllAtendimentoFilterCommand(
				nomePaciente,
				queixaPrincipal,
				diagnostico
		)));
	}

	@GetMapping("/get-atendimento")
	public ResponseEntity<GetAtendimentoUseCase.GetAtendimentoProjetion> getAtendimento(@RequestParam(required = false) String id) {
		return ResponseEntity.ok(this.getAtendimentoUseCase.handle(new GetAtendimentoUseCase.GetAtendimentoCommand(UUID.fromString(id))));
	}

	@PostMapping("/update-atendimento")
	public ResponseEntity<Void> updateAtendimento(final @RequestBody UpdateAtendimentoDTO dto) {
		this.updateAtendimentoUseCase.handle(UpdateAtendimentoUseCase.UpdateAtendimentoCommand.toCommand(dto));
		return ResponseEntity.ok().build();
	}

	@PostMapping("/delete-atendimento")
	public ResponseEntity<Void> deleteAtendimento(@RequestParam(required = false) String id) {
		this.deleteAtendimentoUseCase.handle(new DeleteAtendimentoUseCase.DeleteAtendimentoCommand(UUID.fromString(id)));
		return ResponseEntity.ok().build();
	}
}
