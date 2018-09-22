package conexaoBancoDados;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import identificadorDeObjetos.Promocao;
import identificadorDeObjetos.PromocaoPagueLeve;
import identificadorDeObjetos.PromocaoValorAbsoluto;

public class DAO_Promocoes {
	private static final String INSERT_SQL = "INSERT INTO PROMOCOES(ID, DESCRICAO, OBSERVACAO, QUANTIDADE_ATIVACAO, PRECO_FINAL, QUANTIDADE_PAGA) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SELECT_SQL = "SELECT * FROM PROMOCOES WHERE ID = ?";
	//private static final String UPDATE_SQL = "UPDATE INTO";
	//private static final String DELETE_SQL = "DELETE INTO";
	public static void gerarPromocao(Promocao promocao) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement criar = conexao.prepareStatement(INSERT_SQL)){
			criar.setInt(1, promocao.getID());
			criar.setString(2,promocao.getDescricao());
			criar.setString(3, promocao.getObservacao());
			criar.setInt(4, promocao.getQuantidadeAtivacao());
			if(promocao instanceof PromocaoPagueLeve) {
				criar.setInt(6, ((PromocaoPagueLeve)promocao).getQuantidade_paga());
				criar.setInt(5, -1);
			}
			else if(promocao instanceof PromocaoValorAbsoluto) {
				criar.setBigDecimal(5,((PromocaoValorAbsoluto)promocao).getPreco_final());
				criar.setBigDecimal(6, BigDecimal.valueOf(-1));
			}
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
				if(resultado.getInt("QUANTIDADE_PAGA") != -1) {
					promocao = new PromocaoPagueLeve(resultado.getInt("ID"), resultado.getString("DESCRICAO"), resultado.getString("OBSERVACAO"), resultado.getInt("QUANTIDADE_ATIVACAO"),resultado.getInt("QUANTIDADE_PAGA"));
					return promocao;
				}
				else {
					promocao = new PromocaoValorAbsoluto(resultado.getInt("ID"), resultado.getString("DESCRICAO"), resultado.getString("OBSERVACAO"), resultado.getInt("QUANTIDADE_ATIVACAO"), resultado.getBigDecimal("PRECO_FINAL"));
					return promocao;
				}
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
