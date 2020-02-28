package com.arquivoProcessador.entity;

import java.util.List;

public class Venda extends Entity {

	private Long id;
	private List<ItemVenda> items;
	private String nomeVendedor;

	public Venda(Long id, List<ItemVenda> items, String nomeVendedor) {
		this.id = id;
		this.items = items;
		this.nomeVendedor = nomeVendedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemVenda> getItems() {
		return items;
	}

	public void setItems(List<ItemVenda> items) {
		this.items = items;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public void addItens(ItemVenda item) {
		this.items.add(item);
	}
}
