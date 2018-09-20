package caixa;

import java.math.BigDecimal;

public class Produto {
	private int id;
	private BigDecimal preco;
	private String codigo;
	Promocao promocao = null;
	public Produto(BigDecimal preco, String codigo) {
		this.preco=preco;
		this.codigo=codigo;
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
	public String getCodigo() {
		return codigo;
	}
	public void criaPromocaoValorAbsoluto(int leve, float valor) {
		promocao = new PromocaoValorAbsoluto(leve,valor);
	}
	public void criaPromocaoPagueLeve(int leve, int pague) {
		promocao = new PromocaoPagueLeve(leve,pague);
	}
}