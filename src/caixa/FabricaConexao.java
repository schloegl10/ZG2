package caixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static String url = "jdbc:postgresql://127.0.0.1:63580/browser/ZG";
	public static String usuario = "postgre";
	public static String senha = "122345";
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url,usuario,senha);
		}
		catch(ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}
}
