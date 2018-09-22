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
		BigDecimal valorSemDesconto;
		BigDecimal produtosAbrangidos;
		BigDecimal valorDesconto;
		int verificador;
		verificador=quantidade/getQuantidadeAtivacao();
		
		if(verificador>=1){
			produtosAbrangidos = BigDecimal.valueOf(getQuantidadeAtivacao()).multiply(BigDecimal.valueOf(verificador));
			valorSemDesconto = preco.multiply(produtosAbrangidos);
			valorDesconto = preco_final.multiply(BigDecimal.valueOf(verificador));
			if(valorDesconto.compareTo(valorSemDesconto) < 0) {
				return valorSemDesconto.subtract(valorDesconto);
			}
		}
		
		return BigDecimal.valueOf(0);
	}
}
