package caixa;

import java.math.BigDecimal;
import java.sql.SQLException;

public class MAIM {
	public static void main(String args[]) throws SQLException {
		
		Produto produto = new Produto(1, BigDecimal.valueOf(20,0), "abacateeeeeeee" );
		produto.setPromocao(null);
		Bootstrap.criaTabelas();
		DAO_Produto.deletarProduto(1);
		
		
	}
}
