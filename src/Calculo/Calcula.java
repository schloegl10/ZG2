package calculo;
import java.math.BigDecimal;
import java.util.List;

import dominio.Item;
public class Calcula {
	
	public static BigDecimal getPrecoBruto(List<Item> compra){
		BigDecimal precoTotal= BigDecimal.valueOf(0);
		
		for(int i=0;i<compra.size();i++) {
			precoTotal = precoTotal.add(compra.get(i).produto.getPreco().multiply(BigDecimal.valueOf(compra.get(i).getQuantidade())));
		}
		return precoTotal;
	}
	
	public static BigDecimal getDesconto(List<Item> compra) {
		BigDecimal descontoTotal = new BigDecimal(0);
		BigDecimal descontoProduto;
		BigDecimal valorProduto;
		int quantidadeProduto;
		for(int i=0;i<compra.size();i++) {
			if(compra.get(i).produto.getPromocao()!=null) {
				valorProduto = compra.get(i).produto.getPreco();
				quantidadeProduto = compra.get(i).getQuantidade();
				descontoProduto = compra.get(i).produto.getPromocao().getDesconto(quantidadeProduto, valorProduto);
				descontoTotal = descontoTotal.add(descontoProduto);
			}
		}
		
		return descontoTotal;
	}
	
}
