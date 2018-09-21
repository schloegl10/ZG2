package funcionalidade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import conexaoBancoDados.DAO_Promocoes;
import identificadorDeObjetos.Produto;
import identificadorDeObjetos.Promocao;
import identificadorDeObjetos.PromocaoPagueLeve;
import identificadorDeObjetos.PromocaoValorAbsoluto;

public class LeitorDeTexto {

	public static List<String> getResult(String regex,String text) {
		List<String> participantList = new ArrayList<>();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			String participantName = matcher.group();
			participantList.add(participantName);
		}
		
		return participantList;	
	}
	public ArrayList<Produto> identificadorProduto(List<String> produtoID,List<String> produtoDescricao, List<String> produtoValor, List<String> produtoIDPromocao) throws SQLException {
		ArrayList<Produto> produto = new ArrayList<Produto>();
		Produto produtoTemporario;
		Promocao promocaoTemporaria;
		int id;
		String descricao;
		BigDecimal valor;
		int idPromocao;
		for(int i=0;i<produtoID.size();i++) {
			id = Integer.parseInt(produtoID.get(i));
			descricao = produtoDescricao.get(i);
			valor =  new BigDecimal(produtoValor.get(i));
			idPromocao = Integer.parseInt(produtoIDPromocao.get(i));
			
			produtoTemporario = new Produto(id,descricao,valor);
			
			if(idPromocao !=-1) {
				promocaoTemporaria = DAO_Promocoes.selecionarPromocao(idPromocao);
				produtoTemporario.setPromocao(promocaoTemporaria);
			}
			produto.add(produtoTemporario);
			
		}
		return produto;
		
	}
	public static ArrayList<Promocao> leitorCSV(String url) {
		ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
		Promocao promocaoTemporaria = null;
	    BufferedReader leitor = null;
	    String linha = "";
	    String csvDivisor = ",";
	    int linhaIndice = 0;
	    int id;
	    String descricao;
	    String observacao;
	    int quantidade_ativacao;
	    BigDecimal preco_final;
	    int quantidade_paga;
	    
	    try {

	        leitor = new BufferedReader(new FileReader(url));
	        while ((linha = leitor.readLine()) != null) {
	        	String[] promocao = linha.split(csvDivisor);
	        	if(linhaIndice!=0) {
	        		id = Integer.parseInt(promocao[0]);
	        		descricao = promocao[1];
	        		observacao = promocao[2];
	        		quantidade_ativacao= Integer.parseInt(promocao[3]);
		            if(promocao.length==6) {
		            	quantidade_paga = Integer.parseInt(promocao[5]);
		            	promocaoTemporaria = new PromocaoPagueLeve(id,descricao,observacao,quantidade_ativacao,quantidade_paga);
		            }
		            else if(promocao.length == 5) {
		            	preco_final = new BigDecimal(promocao[4]);
		            	promocaoTemporaria = new PromocaoValorAbsoluto(id,descricao,observacao,quantidade_ativacao,preco_final);
		            }
		            promocoes.add(promocaoTemporaria);
	        	}
	        	linhaIndice++;
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return promocoes;
	}
}
