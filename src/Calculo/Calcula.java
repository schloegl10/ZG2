package Calculo;
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
		BigDecimal descontoTotal=BigDecimal.valueOf(0);
		for(int i=0;i<compra.size();i++) {
			if(compra.get(i).produto.getPromocao()!=null) {
				descontoTotal = descontoTotal.add(compra.get(i).produto.getPromocao().getDesconto(compra.get(i).getQuantidade(), compra.get(i).produto.getPreco()));
			}
		}
		return descontoTotal;
	}
	
}
