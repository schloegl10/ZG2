package caixa;
import java.util.List;
public class Calcula {
	
	public static float getPrecoBruto(List<Item> compra){
		float precoTotal=0;
		
		for(int i=0;i<compra.size();i++) {
			precoTotal += compra.get(i).produto.getPreco() * compra.get(i).getQuantidade();
		}
		return precoTotal;
	}
	
	public static float getDesconto(List<Item> compra) {
		float descontoTotal=0;
		for(int i=0;i<compra.size();i++) {
			if(compra.get(i).produto.promocao!=null) {
				descontoTotal += compra.get(i).produto.promocao.getDesconto(compra.get(i).getQuantidade(), compra.get(i).produto.getPreco());
			}
		}
		return descontoTotal;
	}
	
}
