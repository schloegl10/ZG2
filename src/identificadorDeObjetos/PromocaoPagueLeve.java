package identificadorDeObjetos;

import java.math.BigDecimal;

public class PromocaoPagueLeve extends Promocao {
	public PromocaoPagueLeve(int id, String descricao, String observacao, int quantidade_ativacao, int quantidade_pague) {
		super(id, descricao, observacao, quantidade_ativacao);
		this.quantidade_paga=quantidade_pague;
	}
	private int quantidade_paga;
	public int getQuantidade_paga() {
		return quantidade_paga;
	}
	public void setQuantidadePaga(int quantidadePaga) {
		this.quantidade_paga=quantidadePaga;
		
	}
	public BigDecimal getDesconto(int quantidade, BigDecimal preco) {
		int verificador;
		verificador = quantidade/getQuantidadeAtivacao();
		if(verificador>=1) {
			return preco.multiply(BigDecimal.valueOf(((getQuantidadeAtivacao()-quantidade_paga)*verificador)));
		}
		return BigDecimal.valueOf(0);
	}

}
