package caixa;

import java.math.BigDecimal;

public interface Promocao {
	public BigDecimal getDesconto(int quantidade,BigDecimal preco);
}
