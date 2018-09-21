package caixa;
 import java.sql.*;
import java.util.ArrayList;
public class DAO_Referencias {
	private static final String INSERT_SQL = "INSERT INTO RELACOES(IDPRODUTOS, IDPROMOCAO) VALUES (?, ?)";
	private static final String SELECT_SQL = "SELECT * FROM RELACOES WHERE IDPRODUTOS = ?";
	
	public void gerarProduto(Produto produto) throws SQLException {
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(INSERT_SQL)){
			consulta.setString(1, Integer.toString(produto.getID()));
			consulta.setString(2, produto.getPreco().toString());
			consulta.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Promocao> selecionarPromocao(int id) {
		ArrayList<Promocao> promocao = new ArrayList();
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

}
