package caixa;

import java.math.BigDecimal;

public class Produto {
	private int id;
	private BigDecimal preco;
	private String descricao;
	Promocao promocao = null;
	public Produto(BigDecimal preco, String descricao) {
		this.preco=preco;
		this.descricao=descricao;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void criaPromocaoValorAbsoluto(int leve, BigDecimal valor) {
		promocao = new PromocaoValorAbsoluto(leve,valor);
	}
	public void criaPromocaoPagueLeve(int leve, int pague) {
		promocao = new PromocaoPagueLeve(leve,pague);
	}
}