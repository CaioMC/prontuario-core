package com.titan.prontuario.sys.core.paciente.adpter.in.api;

import com.titan.prontuario.sys.core.paciente.GetAllPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.IncluirPacienteUseCase;
import com.titan.prontuario.sys.core.paciente.adpter.in.api.dto.IncluirPacienteDTO;
import com.titan.prontuario.sys.core.paciente.adpter.in.api.openapi.PacienteControllerOpenApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = PacienteController.PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(name = "Paciente Controller")
public class PacienteController implements PacienteControllerOpenApi {

	public static final String PATH = "api/paciente";

	private final IncluirPacienteUseCase incluirPacienteUseCase;
	private final GetAllPacienteUseCase getAllPacienteUseCase;

	@PostMapping("/incluir-paciente")
	public ResponseEntity<Void> incluirPaciente(final @RequestBody IncluirPacienteDTO dto) {
		this.incluirPacienteUseCase.handle(IncluirPacienteUseCase.IncluirPacienteCommand.toCommand(dto));
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getAll-pacientes")
	public ResponseEntity<List<GetAllPacienteUseCase.GetAllPacientesProjetion>> getAllPacientes(
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String codigo
	) {
		return ResponseEntity.ok(this.getAllPacienteUseCase.handle(new GetAllPacienteUseCase.GetAllPacientesFilterCommand(
				nome,
				codigo
		)));
	}
}