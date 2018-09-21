package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bootstrap {
	public static void criaTabelas() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS PRODUTOS(\n"
				+ "ID INT UNIQUE NOT NULL,\n"
				+ "DESCRICAO VARCHAR(100) UNIQUE NOT NULL,\n"
				+ "VALOR DECIMAL NOT NULL,\n"
				+ "PRIMARY KEY (ID));\n"
				+ "CREATE TABLE IF NOT EXISTS PROMOCOES(\n"
				+ "ID INT UNIQUE NOT NULL,\n"
				+ "DESCIRCAO VARCHAR(100),\n"
				+ "OBSERVACAO VARCHAR(100),\n"
				+ "QUANTIDADE_ATIVACAO INT NOT NULL,\n"
				+ "PRECO_FINAL DECIMAL,\n"
				+ "QUANTIDADE_PAGA INT,"
				+ "PRIMARY KEY (ID));\n"
				+ "CREATE TABLE IF NOT EXISTS RELACOES(\n"
				+ "IDPRODUTOS INT NOT NULL,\n"
				+ "IDPROMOCAO INT NOT NULL,\n"
				+ "FOREIGN KEY (IDPRODUTOS) REFERENCES PRODUTOS(ID),\n"
				+ "FOREIGN KEY (IDPROMOCAO) REFERENCES PROMOCOES(ID));";
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement criacao = conexao.prepareStatement(sql)){
			criacao.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
