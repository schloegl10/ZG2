package conexaoBancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static String url = "jdbc:postgresql://localhost:5432/ZG";
	public static String usuario = "postgres";
	public static String senha = "Schloegl@20";
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url,usuario,senha);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}
}
