package Calculo;

import identificadorDeObjetos.Produto;

public class Item {
	public Produto produto;
	private int quantidade; 
	
	public Item(Produto produto) {
		this.produto = produto;
		quantidade = 0;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
