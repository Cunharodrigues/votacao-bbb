package me.dio.coding.votacao.bbb.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.dio.coding.votacao.bbb.api.model.ParametrizationModel;

public interface ParametrizationRepository extends MongoRepository<ParametrizationModel, String>{

	ParametrizationModel save(ParametrizationModel parametro);

	Optional<ParametrizationModel> findById(String chave);

	
}
