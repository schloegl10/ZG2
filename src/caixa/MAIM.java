package caixa;

import java.math.BigDecimal;
import java.sql.SQLException;

import conexaoBancoDados.DAO_Produto;
import funcionalidade.Bootstrap;
import funcionalidade.LeitorDeTexto;
import identificadorDeObjetos.Produto;

public class MAIM {
	public static void main(String args[]) throws SQLException {
		
		LeitorDeTexto.run("/Users/Felipe/Desktop/promo.csv");
		
		
	}
}
