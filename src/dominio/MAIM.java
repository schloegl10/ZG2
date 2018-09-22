package dominio;

import java.sql.SQLException;

public class MAIM {
	public static void main(String args[]) throws SQLException {
		Caixa caixa = new Caixa();
		caixa.Console(22, Caixa.AdicionaRemove.Adiciona);
		caixa.Console(22, Caixa.AdicionaRemove.Adiciona);
		caixa.Console(22, Caixa.AdicionaRemove.Adiciona);
		caixa.Console(22, Caixa.AdicionaRemove.Adiciona);
		System.out.println(caixa.getPrecoLiquido());
		
	}
}
