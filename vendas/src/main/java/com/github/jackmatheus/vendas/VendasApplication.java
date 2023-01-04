package com.github.jackmatheus.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.github.jackmatheus.entity.Cliente;
import com.github.jackmatheus.repositorio.Clientes;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.github.jackmatheus.*")
@EntityScan("com.github.jackmatheus.*")
@EnableJpaRepositories(basePackages = "com.github.jackmatheus.*")
public class VendasApplication {
    //public CommandLineRunner init(entity Clientes)
	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {

		return args -> {
			System.out.println("Salvando Clientes");
			Cliente cliente = new Cliente();
			cliente.setNome("Cliente 1- Instanciando");
			clientes.salvar(cliente);
			
			Cliente cliente2 = new Cliente("Cliente2 - dentro do construtor");
			clientes.salvar(cliente2);		
			
			clientes.salvar(new Cliente("Cliente3- Dentro do metodo Salvar"));
			
			//Imprimindo cada cliente via toString
			List<Cliente>todosClientes=clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			
			System.out.println("Atualizando Clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome()+" atualizado.");
				clientes.atualizar(c);
			});
			
			todosClientes=clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			
			System.out.println("Buscando Clientes");			
			clientes.buscaporNome("cli").forEach(System.out::println);
			
			
			System.out.println("Deletando Todos Clientes");
				clientes.obterTodos().forEach(c->{
				clientes.deletar(c);
			});
			
			todosClientes=clientes.obterTodos();
			if(todosClientes.isEmpty()) {
				System.out.println("Nenhum Cliente encontrado");
			}else {
				todosClientes.forEach(System.out::println);
				
			}
			
			
			
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
