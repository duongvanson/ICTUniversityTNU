package model;
import java.sql.*;
public class ConnectData {
	String className = "com.mysql.jdbc.Driver";
	String strCon = "jdbc:mysql://localhost:3306/javanangcao";
	String user = "root";
	String pass = "";
	String table = "student";
	Connection conn;
	public void initConnect() {
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(strCon,user,pass);
			System.out.print("OK");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
