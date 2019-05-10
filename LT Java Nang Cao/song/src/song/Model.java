package song;

import java.sql.*;

/**
 *
 * @author dvson
 */
public class Model {
    private Connection connect;
    private PreparedStatement ps;
    private String sql;
    
    public void connectDatabase(){
        String driver = "com.mysql.jdbc.Driver";
        String database = "jdbc:mysql://localhost:3306/mp3";
        String username = "root";
        String password = "";
        
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(database, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void dissConnect() throws SQLException{
        connect.close();
    }
    public ResultSet getAllSong() throws SQLException{
        ResultSet rs = null;
        sql = "select * from song";
        ps = connect.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;
    }
}
