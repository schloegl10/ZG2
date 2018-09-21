package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Promocoes {
	private static final String INSERT_SQL = "INSERT INTO PROMOCOES(ID, DESCRICAO, OBSERVACAO, QUANTIDADE_ATIVACAO, PRECO_FINAL, QUANTIDADE_PAGA) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SELECT_SQL = "SELECT INTO";
	private static final String UPDATE_SQL = "UPDATE INTO";
	private static final String DELETE_SQL = "DELETE INTO";
	public void gerarPromocao(Promocao promocao) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)){
			consulta.setInt(1, promocao.getID());
			consulta.setString(2,promocao.getDescricao());
			consulta.setString(3, promocao.getObservacao());
			consulta.setInt(4, promocao.getQuantidadeAtivacao());
			consulta.setBigDecimal(5,):
			consulta.setInt(6, promocao.get);
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
				return promocao;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
