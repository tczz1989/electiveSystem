package electiveSystem.dbc;

import java.sql.*;

public class Dbconnection {
	
	public Dbconnection() throws Exception{
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(URL, USER, PASS);
		}catch(Exception e) {
			throw e;
		} 
		
	}
	/**
	 * @return the connection
	 */
	public Connection getConn() {
		return conn;
	}
	
	public void close() throws Exception{
		if(this.conn != null) {
			try {
				this.conn.close();
			}catch(Exception e) {
				throw e;
			}
		}
	}
	
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/usr";
	private static final String USER = "root";
	private static final String PASS = "wang1989";
	private Connection conn = null;
}