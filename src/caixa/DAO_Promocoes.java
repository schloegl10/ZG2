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
		Promocao promocao;
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)){
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				if(resultado.getInt("QUANTIDADE_PAGA")==0) {
					promocao = new PromocaoValorAbsoluto(resultado.getInt("ID"), resultado.getString("DESCRICAO"), resultado.getString("OBSERVACAO"), resultado.getInt("QUANTIDADE_ATIVACAO"), resultado.getBigDecimal("PRECO_FINAL"));
				}
				else {
					promocao = new PromocaoPagueLeve(resultado.getInt("ID"), resultado.getString("DESCRICAO"), resultado.getString("OBSERVACAO"), resultado.getInt("QUANTIDADE_ATIVACAO"), resultado.getInt("QUANTIDADE_PAGA"));
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
