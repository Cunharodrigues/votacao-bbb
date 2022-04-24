package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipanteRepository;
import me.dio.coding.votacao.bbb.api.service.VotacaoService;

@RestController
@RequestMapping("/api/votacao")
@AllArgsConstructor
@CrossOrigin

public class VotacaoController {

	private final VotacaoService servico;
	private final ParticipanteRepository repository;

	@PostMapping
	public ResponseEntity<ParticipanteModel> votar(@RequestBody ParticipanteModel participante) {

		Optional<ParticipanteModel> responseOpt = repository.findById(participante.getId());
		if (responseOpt.isEmpty()) {
			throw new RuntimeException("Codigo [" + participante.getId() + "] invalido para votação");
		}

		ParticipanteModel response = responseOpt.get();
		
		servico.adicionarEvento(response);
		return ResponseEntity.ok(response);
	}
}
