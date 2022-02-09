package model.DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			
			Properties props = loadProperties(); /*Carregando as propriedades do arquivo db.properties usando o metodo load*/
			
			String url = props.getProperty("dburl"); /*Usando o url vindo as properties*/
			
			try {
				
				conn = DriverManager.getConnection(url, props); /*Armazenando conexao na variavel conn*/
				
			}catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {

			try {
				conn.close(); /*Fechando a conexao*/
			} catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
				
		}
	}
	
	public static void closeStatatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}catch(Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			
			props.load(fs);
			
			return props;
		}catch(IOException e) {
			throw new DBException(e.getMessage());
		}
	}
}
