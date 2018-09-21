package caixa;

import java.math.BigDecimal;

public class PromocaoValorAbsoluto implements Promocao{
	
	private int id;
	private String descricao;
	private String observacao;
	private int quantidade_ativacao;
	private BigDecimal preco_final;
	private String tipo = "ValorAbsoluto";
	
	public PromocaoValorAbsoluto(int quantidade_ativacao,BigDecimal preco_final) {
		this.quantidade_ativacao=quantidade_ativacao;
		this.preco_final=preco_final;
	}
	
	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public int getQuantidade_ativacao() {
		return quantidade_ativacao;
	}

	public BigDecimal getPreco_final() {
		return preco_final;
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
