package caixa;

import java.math.BigDecimal;
import java.sql.*;

public class DAO_Produto {
	private static final String INSERT_SQL = "INSERT INTO PRODUTOS(ID, DESCRICAO, VALOR) VALUES(?, ?, ?)";
	private static final String SELECT_SQL = "SELECT * FROM PRODUTOS WHERE ID = ?";
	private static final String UPDATE_SQL = "UPDATE PRDOUTOS SET";
	private static final String DELETE_SQL = "DELETE FROM PRODUTOS WHERE ID = ?";
	public static void gerarProduto(Produto produto) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement criar = conexao.prepareStatement(INSERT_SQL)){
			criar.setInt(1, produto.getID());
			criar.setString(2, produto.getDescricao());
			criar.setBigDecimal(3, produto.getPreco());
			criar.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Produto selecionarProduto(int id) throws SQLException {
		Produto produto = new Produto(0,null,null);
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)){
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			if(resultado.next()) {
				produto.setID(resultado.getInt("ID"));
				produto.setDescricao(resultado.getString("DESCRICAO"));
				produto.setPreco(resultado.getBigDecimal("VALOR"));
				produto.setPromocao(DAO_Referencias.selecionarPromocao(id));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
