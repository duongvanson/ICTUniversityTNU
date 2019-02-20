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
			//System.out.print("OK");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
        public void closeConn(){
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        public ResultSet getData(){
            ResultSet rs = null;
            String cmd = "select * from "+table;
            System.out.println(cmd);
            try {
                if(conn != null){
                    Statement st = conn.createStatement();
                    rs = st.executeQuery(cmd);
                }
            } catch (SQLException e) {
                e.getStackTrace();
            }
            return rs;
        }
        public boolean addStudent(String name, String sex, String address){
            initConnect();
            String cmd = "insert into "+table+" values ('0','"+name+"','"+sex+"','"+address+"');";
            //System.out.println(cmd);
            try {
                if(conn != null){
                    Statement st = conn.createStatement();
                    int n = st.executeUpdate(cmd);
                    //System.out.println(n);
                    return n > 0;
                }
            } catch (SQLException e) {
                e.getStackTrace();
            }
            return false;
        }
}