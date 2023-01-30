package com.github.jackmatheus.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.jackmatheus.domain.entity.ClienteSuperClass;

public interface ClientesSuperClass extends JpaRepository<ClienteSuperClass, Integer> {
	//Consulta Sql
	//@Query(value ="select * from ClienteSuperClass c where c.nome like '%:nome%' ", nativeQuery = true)
	//Consulta jpql
	@Query(value ="select c from ClienteSuperClass c where c.nome like :nome")
	List<ClienteSuperClass> encontarClienteSuperClass(@Param("nome") String nome);
	
	@Query( "delete from ClienteSuperClass c where c.nome = :nome")
	@Modifying
	void deleteByNome(String nome);
	
	boolean existsByNome(String nome);
}
