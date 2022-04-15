package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.coding.votacao.bbb.api.model.ParametrizationModel;
import me.dio.coding.votacao.bbb.api.repository.ParametrizationRepository;

@RestController
@RequestMapping("/api/parametros")
public class ParametrizationController {
	
  private final ParametrizationRepository repository;

  public ParametrizationController(ParametrizationRepository repository) {
    this.repository = repository;
  }

  public ParametrizationRepository getRepository() {
    return repository;
  }

  @PostMapping("/salvar")
  public ResponseEntity<ParametrizationModel> salvar(
    @RequestBody ParametrizationModel parametro
  ) {
    ParametrizationModel entidade = repository.save(parametro);
    return ResponseEntity.ok(entidade);
  }

  @GetMapping("/consultar")
  public ResponseEntity<ParametrizationModel> consultar(
    @RequestParam String chave
  ) {
    Optional<ParametrizationModel> optParametro = repository.findById(chave);
    if (optParametro.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(optParametro.get());
  }
}
