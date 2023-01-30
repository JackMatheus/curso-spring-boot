package com.github.jackmatheus.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jackmatheus.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
