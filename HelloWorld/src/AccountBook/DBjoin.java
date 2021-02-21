package AccountBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBjoin {

	public DBjoin() {}
	
	public static void initConnection() {
		String className = "oracle.jdbc.driver.OracleDriver"; 
		try {
			Class.forName(className);
			System.out.println("드라이버 성공");
		} catch (ClassNotFoundException e) {System.out.println("드라이버 실패");;}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("DB 성공");
		} catch (SQLException e) { System.out.println("DB 실패");}
		return conn;		
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null) {conn.close();}
			if (stmt != null) {stmt.close();}
			if (rs != null) {rs.close();}
		} catch (SQLException e) {e.printStackTrace();}
	}
	
}
