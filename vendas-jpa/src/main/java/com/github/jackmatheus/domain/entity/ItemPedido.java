package com.github.jackmatheus.domain.entity;

public class ItemPedido {
	
	private Integer id;
	private Produto Produto;
	private Pedido Pedido;
	private Integer quantidade;
	
	
	public ItemPedido(Produto produto,
			Pedido pedido, Integer quantidade) {
		super();
		Produto = produto;
		Pedido = pedido;
		this.quantidade = quantidade;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Produto getProduto() {
		return Produto;
	}


	public void setProduto(Produto produto) {
		Produto = produto;
	}


	public Pedido getPedido() {
		return Pedido;
	}


	public void setPedido(Pedido pedido) {
		Pedido = pedido;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	

}
