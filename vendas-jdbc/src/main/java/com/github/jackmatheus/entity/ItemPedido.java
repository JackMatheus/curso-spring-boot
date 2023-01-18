package com.github.jackmatheus.entity;

public class ItemPedido {
	
	private Integer id;
	private Pedido pedido;
	private Pedido produto;
	private Integer quantidade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Pedido getProduto() {
		return produto;
	}
	public void setProduto(Pedido produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
