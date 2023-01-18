package com.github.jackmatheus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.jackmatheus.domain.entity.Cliente;
import com.github.jackmatheus.domain.repository.Clientes;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			System.out.println("Salvando Clientes");
			Cliente cliente = new Cliente("Mateuzão");
			// cliente.setNome("Mateuzão");
			clientes.salvar(cliente);

			Cliente cliente2 = new Cliente("Tatinha");
			clientes.salvar(cliente2);

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando Clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + "atualizado.");
				clientes.atualizar(c);

			});
			
			System.out.println("Buscando Clientes");
			clientes.buscaporNome("Ma").forEach(System.out::println);
		
			System.out.println("Deletando Clientes");
			clientes.obterTodos().forEach(c -> {
				clientes.deletar(c);
			});
			todosClientes = clientes.obterTodos();
			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum Clientes encontrado");
			} else {
				todosClientes.forEach(System.out::println);
			}

		};

	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
