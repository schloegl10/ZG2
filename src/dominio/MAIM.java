package dominio;

import java.math.BigDecimal;
import java.sql.SQLException;

import conexaoBancoDados.DAO_Produto;
import funcionalidade.Bootstrap;
import funcionalidade.LeitorDeTexto;
import identificadorDeObjetos.Produto;

public class MAIM {
	public static void main(String args[]) throws SQLException {
		//"/Users/Felipe/Desktop/Arquivo_dados_checkout.txt"
		LeitorDeTexto.run("/Users/Felipe/Desktop/promo.csv");
		
		
	}
}
