package caixa;

import java.math.BigDecimal;

public abstract class Promocao{
	private int id;
	private String descricao;
	private String observacao;
	private int quantidade_ativacao;
	private enum tipo{
		valor_final,
		pegue_leve;
	}
	tipo tipo;
	public Promocao(int id, String descricao, String observacao, int quantidade_ativacao) {
		this.id=id;	
		this.descricao=descricao;
		this.observacao=observacao;
		this.quantidade_ativacao=quantidade_ativacao;
	}
	
	public int getID() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public int getQuantidadeAtivacao() {
		return quantidade_ativacao;
	}
	
	public tipo getTipo() {
		return tipo;
	}
	
	public void setID(int id) {
		this.id= id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao=descricao;
		
	}
	
	public void setObservacao(String observacao) {
		this.observacao=observacao;
		
	}
	
	public void setQuantidadeAtivacao(int quantidadeAtivacao) {
		this.quantidade_ativacao=quantidadeAtivacao;
		
	}
	public abstract BigDecimal getDesconto(int quantidade, BigDecimal preco);

}