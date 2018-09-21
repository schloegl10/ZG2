package caixa;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Produto {
	private int id;
	private BigDecimal preco;
	private String descricao;
	ArrayList<Promocao> promocao = new ArrayList<Promocao>();
	public Produto(int id,BigDecimal preco, String descricao) {
		this.id=id;
		this.preco=preco;
		this.descricao=descricao;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPromocao(ArrayList<Promocao> promocao) {
		this.promocao=promocao;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return id;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public String getDescricao() {
		return descricao;
	}
}