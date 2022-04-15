package me.dio.coding.votacao.bbb.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ComponentScan(basePackages = "me.dio.coding.votacao.bbb.api.controller,me.dio.coding.votacao.bbb.api.service, me.dio.coding.votacao.bbb.api.model,"
							+ " me.dio.coding.votacao.bbb.api.repository, me.dio.coding.votacao.bbb.api")*/
public class VotacaoBbbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotacaoBbbApiApplication.class, args);
	}

}
