package caixa;

import java.math.BigDecimal;

public class PromocaoPagueLeve implements Promocao{
	private int id;
	private String descricao;
	private String observacao;
	private int quantidade_ativacao;
	private int quantidade_paga;
	private String tipo = "Pague-Leve";
	public PromocaoPagueLeve(int quantidade_ativacao,int quantidade_paga) {
		this.quantidade_ativacao=quantidade_ativacao;
		this.quantidade_paga=quantidade_paga;
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

	public int getQuantidade_paga() {
		return quantidade_paga;
	}

	public String getTipo() {
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
	public void setQuantidadePaga(int quantidadePaga) {
		this.quantidade_paga=quantidadePaga;
		
	}
	public BigDecimal getDesconto(int quantidade, BigDecimal preco) {
		int verificador;
		verificador = quantidade/quantidade_ativacao;
		if(verificador>=1) {
			return preco.multiply(BigDecimal.valueOf(((quantidade_ativacao-quantidade_paga)*verificador)));
		}
		return BigDecimal.valueOf(0);
	}
}
