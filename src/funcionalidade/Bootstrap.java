package funcionalidade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoBancoDados.DAO_Produto;
import conexaoBancoDados.DAO_Promocoes;
import conexaoBancoDados.FabricaConexao;
import identificadorDeObjetos.Produto;
import identificadorDeObjetos.Promocao;

public class Bootstrap {
	public static void criaTabelas() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS PROMOCOES(\n"
				+ "ID INT UNIQUE NOT NULL,\n"
				+ "DESCRICAO VARCHAR(100),\n"
				+ "OBSERVACAO VARCHAR(100),\n"
				+ "QUANTIDADE_ATIVACAO INT NOT NULL,\n"
				+ "PRECO_FINAL DECIMAL,\n"
				+ "QUANTIDADE_PAGA INT,"
				+ "PRIMARY KEY (ID));\n"
				+ "CREATE TABLE IF NOT EXISTS PRODUTOS(\n"
				+ "ID INT UNIQUE NOT NULL,\n"
				+ "DESCRICAO VARCHAR(100) UNIQUE NOT NULL,\n"
				+ "VALOR DECIMAL NOT NULL,\n"
				+ "IDPROMOCAO INT,\n"
				+ "PRIMARY KEY (ID),\n"
				+ "FOREIGN KEY (IDPROMOCAO) REFERENCES PROMOCOES(ID));";
		try(Connection conexao = FabricaConexao.getConexao();
				PreparedStatement criacao = conexao.prepareStatement(sql)){
			criacao.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void geradorProdutos(String url) throws SQLException {
		List<String> produtoID;
		List<String> produtoDescricao;
		List<String> produtoValor;
		List<String> produtoIDPromocao;
		ArrayList<Produto> produto;
		String data = "";
		try { 
			data = new String(Files.readAllBytes(Paths.get(url)));
			produtoID = LeitorDeTexto.lerParametro("(?<=id\\:\\s)\\d+(?=\\|)", data);
			produtoDescricao = LeitorDeTexto.lerParametro("(?<=descricao\\:\\s)[\\w\\s]+(?=\\|)", data);
			produtoValor = LeitorDeTexto.lerParametro("(?<=valor\\:\\s)[0-9\\.]+(?=\\|)", data);
			produtoIDPromocao = LeitorDeTexto.lerParametro("(?<=promocao\\:\\s)[0-9\\-]+(?=\\|)", data);
			produto = LeitorDeTexto.identificadorProduto(produtoID, produtoDescricao, produtoValor, produtoIDPromocao);
			for(int i = 0; i<produto.size();i++) {
				if(DAO_Produto.selecionarProduto(produto.get(i).getID())== null) {
					DAO_Produto.gerarProduto(produto.get(i));
				}
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void geradorPromocao(String url) throws SQLException {
		ArrayList<Promocao> promocao;
		promocao = LeitorDeTexto.identificadorPomocao(url);
		for(int i = 0; i<promocao.size();i++) {
			if(DAO_Promocoes.selecionarPromocao(promocao.get(i).getID())==null) {
				DAO_Promocoes.gerarPromocao(promocao.get(i));
			}
		}
	}
}
