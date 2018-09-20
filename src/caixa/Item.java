package caixa;

public class Item {
	Produto produto;
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
