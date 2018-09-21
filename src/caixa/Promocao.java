package caixa;

import java.math.BigDecimal;

public class Promocao{
	private int id;
	private String descricao;
	private String observacao;
	private int quantidade_ativacao;
	private BigDecimal preco_final;
	private int quantidade_paga;
	private String tipo;
	public Promocao(int id, String descricao, String observacao, int quantidade_ativacao,BigDecimal preco_final, int quantidade_paga) {
		this.id=id;	
		this.descricao=descricao;
		this.observacao=observacao;
		this.quantidade_ativacao=quantidade_ativacao;
		this.preco_final=preco_final;
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
	
	public BigDecimal getPreco_final() {
		return preco_final;
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
	
	public void setPrecoFinal(BigDecimal preco_final) {
		this.preco_final.equals(preco_final);
	}
	
	public BigDecimal getDesconto(int quantidade, BigDecimal preco) {
		int verificador;
		verificador = quantidade/quantidade_ativacao;
		if(verificador>=1) {
			return preco.multiply(BigDecimal.valueOf(((quantidade_ativacao-quantidade_paga)*verificador)));
		}
		return BigDecimal.valueOf(0);
	}
	/*public BigDecimal getDesconto(int quantidade,BigDecimal preco) {
		
		int verificador;
		verificador=quantidade/quantidade_ativacao;
		
		if(verificador>=1){
			
			return preco.multiply(BigDecimal.valueOf(quantidade_ativacao).multiply(BigDecimal.valueOf(verificador)).subtract(preco_final.multiply(BigDecimal.valueOf(verificador))));
		}
		
		return BigDecimal.valueOf(0);
	}*/
}
