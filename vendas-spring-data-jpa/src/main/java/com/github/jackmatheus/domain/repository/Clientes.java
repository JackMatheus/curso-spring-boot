package com.github.jackmatheus.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.jackmatheus.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {
	// Trata-se de Query methods
	// Spring transforme o método em uma query
	// select c from Cliente c where c.nome like :nome
	List<Cliente> findByNomeLike(String nome);

	// select c from Cliente c where c.nome like :nome
	@Query(value = "select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
	List<Cliente> encontrarPorNome(@Param("nome") String nome);

	List<Cliente> findByNomeLikeOrIdOrderById(String nome, Integer Id);

	// Retornando 1 cliente
	Cliente findOneByNome(String nome);

	// Retornando true or false se existe
	boolean existsByNome(String nome);

	// Exemplo de Queries
	// Retornando 1 cpf
	//Cliente findOneByCpf(String cpf);

	@Query(" delete from Cliente c where c.nome =:nome ")
	@Modifying
	void deleteByNome(String nome);

	@Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
	Cliente findClienteFetchPedidos(@Param("id") Integer id);
	
	

}
