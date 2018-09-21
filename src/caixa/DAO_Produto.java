package caixa;

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
			for(int i=0;i<produto.promocao.size();i++) {
				DAO_Referencias.gerarReferencia(produto.getID(), produto.promocao.get(i).getID());
			}
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
	public static void deletarProduto(int id) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement deletar = conexao.prepareStatement(DELETE_SQL)){
			deletar.setInt(1, id);
			DAO_Referencias.deletarReferencia(id,"-Produto");
			deletar.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
