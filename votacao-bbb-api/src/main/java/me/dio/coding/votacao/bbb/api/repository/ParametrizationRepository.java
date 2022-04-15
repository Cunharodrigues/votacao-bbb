package me.dio.coding.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.dio.coding.votacao.bbb.api.model.ParametrizationModel;

public interface ParametrizationRepository extends MongoRepository<ParametrizationModel, String>{

		
}
