package caixa;

import java.math.BigDecimal;

public interface Promocao {
	public BigDecimal getDesconto(int quantidade,BigDecimal preco);
	public void setID(int id);
	public int getID();
	public void	setDescricao(String descricao);
	public void setObservacao(String observacao);
	public void setQuantidadeAtivacao(int quantidadeAtivacao);
	public String getDescricao();
	public String getObservacao();
	public int getQuantidadeAtivacao();
	
}
