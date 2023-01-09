package com.github.jackmatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jackmatheus.model.Cliente;
import com.github.jackmatheus.repository.ClientesRepository;

@Service
public class ClientesService {

	private ClientesRepository repository;
	
	@Autowired
	public ClientesService (ClientesRepository repository) {
		this.repository = repository;
	}

	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		// Não é correto acessar a base de dados diretamente pq pode estourar
		// ClientesRepository repository = new ClientesRepository();
		this.repository.persistir(cliente);
	}

	public void validarCliente(Cliente cliente) {
	}
	// aplicar validações
}
