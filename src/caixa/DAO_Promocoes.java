package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Promocoes {
	private static final String INSERT_SQL = "INSERT INTO";
	private static final String SELECT_SQL = "SELECT INTO";
	private static final String UPDATE_SQL = "UPDATE INTO";
	private static final String DELETE_SQL = "DELETE INTO";
	public void gerarPromocao(Promocao promocao) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)){
			consulta.setInt(1, promocao);
			consulta.setString(2,);
			consulta.setString(3,);
			consulta.setString(4,);
			consulta.setString(5,):
			consulta.setString(6,);
			consulta.executeUpdate(
					);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Promocao selecionarPromocao(int id) throws SQLException {
		Promocao promocao = null;
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
