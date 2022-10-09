package com.will.gerenciadormontagem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gerenciador de profissionais", version = "1.0", description = "Informações sobre a API"))
public class GerenciadorMontagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorMontagemApplication.class, args);
	}

}
