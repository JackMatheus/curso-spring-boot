package com.github.jackmatheus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome", length = 100)
	private String nome;

	@ManyToMany
	//@JoinTable(name = "Conteudos_Medias", joinColumns = "A")
	private List<Pedido> pedido = new ArrayList<Pedido>();

	public Cliente() {
		super();
	}

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public Cliente(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [" + "id=" + id + "" + ", " + "nome=" + nome + '\'' + "]";
	}

}
