package dominio;

import java.sql.SQLException;

import funcionalidade.Bootstrap;

public class MAIM {
	public static void main(String args[]) throws SQLException {
		Bootstrap.criaTabelas("/users/Felipe/eclipse-workspace/ZG2/src/texts/tabela.sql");
		Bootstrap.geradorPromocao("/users/Felipe/eclipse-workspace/ZG2/src/texts/promo.csv");
		Bootstrap.geradorProdutos("/users/Felipe/eclipse-workspace/ZG2/src/texts/Arquivo_dados_checkout.txt");
		
	}
}
