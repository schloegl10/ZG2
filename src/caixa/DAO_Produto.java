package caixa;

import java.sql.*;

public class DAO_Produto {
	private static final String SELECT_SQL = "INSERT INTO produtos(id, descricao, valor) VALUES (?, ?, ?)";
	public void gerarProduto(Produto produto) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)){
			consulta.setString(1, produto.getID());
			consulta.setString(2, produto.getPreco());
			consulta.setString(3, produto.getCodigo());
		}
		catch(SQLException e) {
			log.severe(e.getMessage());
		}
	}
}
