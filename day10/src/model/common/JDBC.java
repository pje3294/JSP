package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	public static Connection connect() {
		Connection conn= null;
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"park","1234");
		} catch (Exception e) {
			System.out.println("connect() ¿À·ù ·Î±ë!");
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("disconnect() ¿À·ù ·Î±ë!");
			e.printStackTrace();
		}
	}
	
	
	
	
}
