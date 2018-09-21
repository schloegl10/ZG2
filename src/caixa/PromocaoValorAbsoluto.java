package caixa;

import java.math.BigDecimal;

public class PromocaoValorAbsoluto implements Promocao{
	
	private int id;
	private String descricao;
	private String observacao;
	private int quantidade_ativacao;
	private BigDecimal preco_final;
	private String tipo = "ValorAbsoluto";
	
	public PromocaoValorAbsoluto(int id,String descricao, String observacao,int quantidade_ativacao,BigDecimal preco_final) {
		this.id=id;	
		this.descricao=descricao;
		this.observacao=observacao;
		this.quantidade_ativacao=quantidade_ativacao;
		this.preco_final=preco_final;
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
	public BigDecimal getPreco_final() {
		return preco_final;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void setID(int id) {
		this.id=id;	
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
	public void setPrecoFinal(BigDecimal preco_final) {
		this.preco_final.equals(preco_final);
	}
	
	public BigDecimal getDesconto(int quantidade,BigDecimal preco) {
		
		int verificador;
		verificador=quantidade/quantidade_ativacao;
		
		if(verificador>=1){
			
			return preco.multiply(BigDecimal.valueOf(quantidade_ativacao).multiply(BigDecimal.valueOf(verificador)).subtract(preco_final.multiply(BigDecimal.valueOf(verificador))));
		}
		
		return BigDecimal.valueOf(0);
	}
}
