package com.github.jackmatheus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.jackmatheus.domain.entity.Cliente;
import com.github.jackmatheus.domain.entity.ClienteSuperClass;
import com.github.jackmatheus.domain.entity.Pedido;
import com.github.jackmatheus.domain.repository.Clientes;
import com.github.jackmatheus.domain.repository.ClientesSuperClass;
import com.github.jackmatheus.domain.repository.Pedidos;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes, @Autowired ClientesSuperClass clientesSuperClass,
			@Autowired Pedidos pedidos) {
		return args -> {
			System.out.println("Salvando Clientes");
			Cliente cliente = new Cliente("Mateuzão");
			// cliente.setNome("Mateuzão");
			clientes.save(cliente);

			Cliente cliente2 = new Cliente("Tatinha");
			clientes.save(cliente2);
			// Aki
			// Pedido p = new Pedido(cliente, LocalDate.now(), BigDecimal.valueOf(100));
			Pedido p = new Pedido();
			p.setCliente(cliente);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			pedidos.save(p);

			// Buscando no banco de dados
//			Cliente clienteFulano = clientes.findClienteFetchPedidos(cliente.getId());
//			System.out.println(clienteFulano);
//			System.out.println(cliente.getPedidos());

			// Buscando no banco de dados
			// List<Pedido> listaPedidos = pedidos.findByCliente(cliente);
			// System.out.println(listaPedidos);
			System.out.println(" AKI - Lista Pedidos do cliente");			
			pedidos.findByCliente(cliente).forEach(System.out::println);

			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			boolean existe = clientes.existsByNome("João");
			System.out.println("Existe um cliente com o nome João  " + existe);
			boolean existe2 = clientes.existsByNome("Mateuzão");
			System.out.println("Existe um cliente com o nome Mateuzão  " + existe2);

			System.out.println("Atualizando Clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + "atualizado.");
				clientes.save(c);

			});

			System.out.println("Buscando Clientes");
			clientes.findByNomeLike("Ma").forEach(System.out::println);

			System.out.println("Buscando Clientes por nome-Ma ou Id-2");
			clientes.findByNomeLikeOrIdOrderById("Ma", 2).forEach(System.out::println);

			System.out.println("Deletando Clientes só q não");
//			clientes.findAll().forEach(c -> {
//				clientes.delete(c);
//			});
			todosClientes = clientes.findAll();
			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum Clientes encontrado");
			} else {
				todosClientes.forEach(System.out::println);
			}

			System.out.println("///////////////////////Cliente Super Class ////////////////////////");
			// ClienteSuperClass clienteSuperClass = new ClienteSuperClass("Mateuzão Super
			// Class");
			// clienteSuperClass.setNome("Mateuzão");
			// clientesSuperClass.save(clienteSuperClass);

			// ClienteSuperClass clienteSuperClass = new ClienteSuperClass("Mateuzão Super
			// Class");
			// clienteSuperClass.setNome("Mateuzão");
			clientesSuperClass.save(new ClienteSuperClass("Mateuzão Super Class"));

			List<ClienteSuperClass> existResult = clientesSuperClass.encontarClienteSuperClass("Mateuzão Super Class");
			existResult.forEach(System.out::println);

			System.out.println("Deletando Clientes Super Class só q não");
//			clientesSuperClass.findAll().forEach(c -> {
//				clientesSuperClass.delete(c);
//			});	

		};

	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
