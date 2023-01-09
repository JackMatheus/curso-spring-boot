package com.github.jackmatheus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//@Profile("development")
@Development
public class MinhaConfiguracao {
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("Rodando a configuração de desenvolvimento");
		};
		
	}
	
	
	@Bean(name="applicationName")
	public String applicationName() {
		return "Sistema de Vendas";
		
	}
	
	@Bean(name="applicationMeuRepositorio")
	public String applicationRepositorio() {
		return "MeuRepositorio";
		
	}
	
	@Bean(name="applicationService")
	public String applicationService() {
		return "Minha Service";
		
	}

}
