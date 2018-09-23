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
	private static final String UPDATE_SQL = "UPDATE PROMOCOES SET";
	private static final String DELETE_SQL = "DELETE FROM PROMOCOES WHERE ID = ?";
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

	public static Promocao selecionarPromocao(int idPromocao) throws SQLException {
		Promocao promocao;
		int id;
		String descricao;
		String observacao;
		int quantidade_ativacao;
		BigDecimal preco_final;
		int quantidade_paga;
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)){
			consulta.setInt(1, idPromocao);
			ResultSet resultado = consulta.executeQuery();
			if(resultado.next()) {
				id = resultado.getInt("ID");
				descricao = resultado.getString("DESCRICAO");
				observacao = resultado.getString("OBSERVACAO");
				quantidade_ativacao = resultado.getInt("QUANTIDADE_ATIVACAO");
				preco_final = resultado.getBigDecimal("PRECO_FINAL");
				quantidade_paga = resultado.getInt("QUANTIDADE_PAGA");
				if(quantidade_paga != -1) {
					promocao = new PromocaoPagueLeve(id,descricao,observacao,quantidade_ativacao,quantidade_paga);
					return promocao;
				}
				else if(preco_final != BigDecimal.valueOf(-1)){
					promocao = new PromocaoValorAbsoluto(id,descricao,observacao,quantidade_ativacao,preco_final);
					return promocao;
				}
				return null;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public static void alterarPromocaoCompleta(Promocao promocao) throws SQLException {
		String UPDATE_SQL2;
		UPDATE_SQL2 = UPDATE_SQL+" DESCRICAO = ?, OBSERVACAO = ?, QUANTIDADE_ATIVACAO = ?, PRECO_FINAL = ?, QUANTIDADE_PAGA = ? WHERE ID = ?";
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement alterar = conexao.prepareStatement(UPDATE_SQL2)){
			alterar.setString(1, promocao.getDescricao());
			alterar.setString(2, promocao.getObservacao());
			alterar.setInt(3, promocao.getQuantidadeAtivacao());
			if(promocao instanceof PromocaoPagueLeve) {
				alterar.setBigDecimal(4, BigDecimal.valueOf(-1));
				alterar.setInt(5, ((PromocaoPagueLeve) promocao).getQuantidade_paga());
			}
			else if(promocao instanceof PromocaoValorAbsoluto){
				alterar.setBigDecimal(4, ((PromocaoValorAbsoluto) promocao).getPreco_final());
				alterar.setInt(5, -1);
			}
			alterar.setInt(6, promocao.getID());
			alterar.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deletarPromocao(int id) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement deletar = conexao.prepareStatement(DELETE_SQL)){
			DAO_Produto.retirarPromocaoProduto(id);
			deletar.setInt(1, id);
			deletar.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	} 
}
