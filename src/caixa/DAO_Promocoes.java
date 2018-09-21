package caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Promocoes {
	private static final String INSERT_SQL = "INSERT INTO PROMOCOES(ID, DESCRICAO, OBSERVACAO, QUANTIDADE_ATIVACAO, PRECO_FINAL, QUANTIDADE_PAGA) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SELECT_SQL = "SELECT * FROM PROMOCOES WHERE ID = ?";
	private static final String UPDATE_SQL = "UPDATE INTO";
	private static final String DELETE_SQL = "DELETE INTO";
	public void gerarPromocao(Promocao promocao) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement criar = conexao.prepareStatement(INSERT_SQL)){
			criar.setInt(1, promocao.getID());
			criar.setString(2,promocao.getDescricao());
			criar.setString(3, promocao.getObservacao());
			criar.setInt(4, promocao.getQuantidadeAtivacao());
			criar.setBigDecimal(5,promocao.getPreco_final());
			criar.setInt(6, promocao.getQuantidade_paga());
			criar.executeUpdate();
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
				promocao = new Promocao(resultado.getInt("ID"), resultado.getString("DESCRICAO"), resultado.getString("OBSERVACAO"), resultado.getInt("QUANTIDADE_ATIVACAO"), resultado.getBigDecimal("PRECO_FINAL"), resultado.getInt("QUANTIDADE_PAGA"));
				return promocao;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public static void alterarPromocaoCompleta(Promocao promocao) throws SQLException {
		String UPDATE_SQL2=UPDATE_SQL+"DESCRICAO = ?, VALOR = ? WHERE ID = ?";
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement alterar = conexao.prepareStatement(UPDATE_SQL2)){
			alterar.setString(1, produto.getDescricao());
			alterar.setBigDecimal(2, produto.getPreco());
			alterar.setInt(3, produto.getID());
			for(int i=0;i<produto.promocao.size();i++) {
				DAO_Referencias.alterarReferencia(produto.getID(), produto.promocao.get(i).getID(),"produto");
			}
			alterar.executeUpdate();
		}
	}
	public static void deletarPromocao(int id) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement deletar = conexao.prepareStatement(DELETE_SQL)){
			deletar.setInt(1, id);
			DAO_Referencias.deletarReferencia(id,"-Promocao");
			deletar.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
