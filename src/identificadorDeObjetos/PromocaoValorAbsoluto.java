package identificadorDeObjetos;

import java.math.BigDecimal;

public class PromocaoValorAbsoluto extends Promocao{
	public PromocaoValorAbsoluto(int id, String descricao, String observacao, int quantidade_ativacao, BigDecimal preco_final) {
		super(id, descricao, observacao, quantidade_ativacao);
		this.preco_final=preco_final;
	}

	private BigDecimal preco_final;
	public BigDecimal getPreco_final() {
		return preco_final;
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
