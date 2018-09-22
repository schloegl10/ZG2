package dominio;
import java.math.BigDecimal;
import java.util.ArrayList;

import Calculo.Calcula;
import identificadorDeObjetos.Produto;
public class Caixa {
	ArrayList<Item> compra = new ArrayList<Item>();
	public enum adicionaRemove{
		Adiciona,Remove;
	}
	public void Console(String codigo,adicionaRemove acao) {
		Produto produto = Bd.getProduto(codigo);
		
		if(produto!=null) {
			if(acao==adicionaRemove.Adiciona) {
				addItem(produto);
			}
			else {
				removerItem(produto);
			}
		}
	}
	
	public void removerItem(Produto produto) {
		int indiceItem=verificaItem(produto);
		if(indiceItem!=-1) {
			compra.get(indiceItem).setQuantidade(compra.get(indiceItem).getQuantidade()-1);
			if(compra.get(indiceItem).getQuantidade() == 0) {
				compra.remove(indiceItem);
			}
		}
	}
	public void addItem(Produto produto) {
		int indiceItem;
		indiceItem=verificaItem(produto);
		if(indiceItem!=-1) {
			compra.get(indiceItem).setQuantidade(compra.get(indiceItem).getQuantidade()+1);
		}			
		else {
			Item item = new Item(produto);
			item.setQuantidade(item.getQuantidade()+1);
			compra.add(item);
		}
	}
	
	public int verificaItem(Produto produto) {
		for(int i = 0;i<compra.size();i++) {
			if(produto == compra.get(i).produto) {
				return i;
			}
		}
		return -1;
	}
	public BigDecimal getPrecoLiquido() {
		BigDecimal precoLiquido=BigDecimal.valueOf(0);
		precoLiquido=Calcula.getPrecoBruto(compra).subtract(Calcula.getDesconto(compra));
		return precoLiquido;
	}
	public void rest() {
		compra = new ArrayList<Item>();
	}
	
}
