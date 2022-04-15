package me.dio.coding.votacao.bbb.api.controller;

import me.dio.coding.votacao.bbb.api.model.ParametrizationModel;
import me.dio.coding.votacao.bbb.api.repository.ParametrizationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parametros")
public class ParametrizationController {

	private final ParametrizationRepository repository;

	public ParametrizationController(ParametrizationRepository repository) {
		this.repository = repository;
	}

	/*
	 * public ParametrizationRepository getRepository() { return repository; }
	 */

	@PostMapping("/salvar")
	public ResponseEntity<ParametrizationModel> salvar(@RequestBody ParametrizationModel parametro) {
		ParametrizationModel entidade = repository.save(parametro);
		return ResponseEntity.ok(entidade);
	}

	@GetMapping("/consultar")
	public ResponseEntity<ParametrizationModel> consulta(@RequestParam String chave) {
		Optional<ParametrizationModel> optParametro = repository.findById(chave);
		if (optParametro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optParametro.get());
	}
}
