package Datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Exceptions.ConnectionNotPossibleException;
import Exceptions.DriverNotFoundException;
import Exceptions.NoDatabaseAccess;

public class DatenbankZugriff {

	private Connection conn;
	private final String driver= "org.sqlite.JDBC";
	private final String url="jdbc:sqlite:Kingdom.sqlite";
	//private final String exceptionMessage="Connection not possible";
	
	
public Connection open() throws ConnectionNotPossibleException, DriverNotFoundException, NoDatabaseAccess {
		
		if(this.conn == null) {
			
				
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					throw new DriverNotFoundException();
				}
				try {
					conn = DriverManager.getConnection(url);
				} catch (SQLException e) {
					throw new NoDatabaseAccess();
				}
				System.out.print("Connection succesfull");
				return conn;
				
			
		}
		return conn;
		
		
	}
	
	
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=null;
		}
	}
}
