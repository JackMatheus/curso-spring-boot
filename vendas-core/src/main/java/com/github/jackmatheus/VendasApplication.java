package com.github.jackmatheus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.github.jackmatheus.repository", "com.github.jackmatheus.service"})
@RestController
public class VendasApplication {
    @Value("${application.name}")
	//@Autowired
    //@Qualifier("applicationName")
    private String applicationName;
    
    //Injetando o Animal
    //@Autowired
    //@Qualifier("gato")
    @Cachorro
    private Animal animal;
  //Injetando bean xx para testar animal
    @Bean(name="executarAnimal")
    public CommandLineRunner executar() {
		return args -> {
			//Mandando o animal fazr barulho
			this.animal.fazerBarulho();
		};
    	
    }
    
    @GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	};
	
	//applicationMeuRepositorio
    @Autowired
    @Qualifier("applicationMeuRepositorio")
    private String applicationMeuRepositorio;
    
    @GetMapping("/helloRepo")
    public String helloWorldRepo() {
    	return applicationMeuRepositorio;
    };
    
    //applicationService
    @Autowired
    @Qualifier("applicationService")
    private String applicationService;
    
    @GetMapping("/helloService")
    public String helloWorldService() {
    	return applicationService;
    };
    
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
