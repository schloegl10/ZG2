package identificadorDeObjetos;

import java.math.BigDecimal;

public class Produto {
	private int id;
	private BigDecimal preco;
	private String descricao;
	private Promocao promocao;
	public Produto(int id, String descricao,BigDecimal preco) {
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
	public void setPromocao(Promocao promocao) {
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
	public Promocao getPromocao() {
		return promocao;
	}
}