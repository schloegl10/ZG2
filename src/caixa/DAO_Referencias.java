package caixa;
 import java.sql.*;
import java.util.ArrayList;
public class DAO_Referencias {
	private static final String INSERT_SQL = "INSERT INTO RELACOES(IDPRODUTOS, IDPROMOCAO) VALUES (?, ?)";
	private static final String SELECT_SQL = "SELECT * FROM RELACOES WHERE IDPRODUTOS = ?";
	private static final String UPDATE_SQL = "UPDATE RELACOES SET";
	private static final String DELETE_SQL = "DELETE FROM RELACOES WHERE ID";
	
	public static void gerarReferencia(int idProduto, int idPromocao) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement criar = conexao.prepareStatement(INSERT_SQL)){
			criar.setInt(1, idProduto);
			criar.setInt(2, idPromocao);
			criar.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Promocao> selecionarPromocao(int id) {
		ArrayList<Promocao> promocao = new ArrayList<Promocao>();
		int idPromocao;
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)){
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			if(resultado.next()) {
				idPromocao = resultado.getInt("IDPRODUTOS");
				promocao.add(DAO_Promocoes.selecionarPromocao(idPromocao));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return promocao;
	}
	public static void alterarProdutoCompleto(Produto produto) throws SQLException {
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
	public static void deletarReferencia(int id,String tipoID) throws SQLException {
		String DELETE_SQL1 = DELETE_SQL;
		if(tipoID == "-Produto"){
			DELETE_SQL1+="PRODUTOS = ?";
		}
		else {
			DELETE_SQL1+="PROMOCAO = ?";
		}
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement deletar = conexao.prepareStatement(DELETE_SQL1)){
			deletar.setInt(1, id);
			deletar.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

