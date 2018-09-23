package dominio;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import calculo.Calcula;
import funcionalidade.Bootstrap;
import identificadorDeObjetos.Produto;
public class Caixa {
	ArrayList<Item> compra = new ArrayList<Item>();
	public enum AdicionaRemove{
		Adiciona,Remove;
	}
	public void Console(int id, AdicionaRemove acao) throws SQLException {
		Produto produto = Bootstrap.selecionaProduto(id);
		
		if(produto!=null) {
			if(acao==AdicionaRemove.Adiciona) {
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
		int quantidadeFinal;
		indiceItem=verificaItem(produto);
		if(indiceItem!=-1) {
			quantidadeFinal = compra.get(indiceItem).getQuantidade()+1;
			compra.get(indiceItem).setQuantidade(quantidadeFinal);
		}			
		else {
			Item item = new Item(produto);
			quantidadeFinal = item.getQuantidade()+1;
			item.setQuantidade(quantidadeFinal);
			compra.add(item);
		}
	}
	
	public int verificaItem(Produto produto) {
		for(int i = 0;i<compra.size();i++) {
			if(produto.getID() == compra.get(i).produto.getID()) {
				return i;
			}
		}
		return -1;
	}
	public BigDecimal getPrecoLiquido() {
		
		return Calcula.getPrecoBruto(compra).subtract(Calcula.getDesconto(compra));
	}
	public void fimDaCompra() {
		compra = new ArrayList<Item>();
	}
	
}
