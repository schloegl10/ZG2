package dominio;

import java.sql.SQLException;

import funcionalidade.Bootstrap;

public class MAIM {
	public static void main(String args[]) throws SQLException {
		//
		Bootstrap.criaTabelas();
		Bootstrap.geradorPromocao("/Users/Felipe/Desktop/promo.csv");
		Bootstrap.geradorProdutos("/Users/Felipe/Desktop/Arquivo_dados_checkout.txt");
		
		
	}
}
