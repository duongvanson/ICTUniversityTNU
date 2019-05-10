package songnew;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dvson
 */
public class Model {
    Connection connect;
    PreparedStatement ps;
    String sql = "";
    public void initData() throws ClassNotFoundException, SQLException{
        String name = "com.mysql.jdbc.Driver";
        String database = "jdbc:mysql://localhost/mp3?characterEncoding=UTF-8";
        String user = "root";
        String pass = "";
        Class.forName(name);
        connect = DriverManager.getConnection(database, user, pass);
    }
    public ResultSet getAll(String table) throws SQLException{
        sql = "select * from "+table;
        ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet getSong(int id) throws SQLException{
        sql = "select * from song where id = '"+id+"'";
        Statement st = connect.createStatement();
        return st.executeQuery(sql);
    }
    public boolean  updateSong(String id, String name, String author, String year) throws SQLException{
        sql = "update song set name= ?, author=?, year=? where id= ?";
        ps = connect.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, author);
        ps.setString(3, year);
        ps.setString(4, id);
        return ps.executeUpdate() > 0;
    }
    public boolean insertSong(String id, String name, String author, String year) throws SQLException{
        sql = "insert into song values("
                +"'" + id +"',"
                +"'" + name +"',"
                +"'" + author +"',"
                +"'" + year +"'"
                +")";
        Statement st = connect.createStatement();
        try {
            return st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean deleteSong(String id) throws SQLException{
        sql = "delete from song where id ='"+id+"'";
        Statement st = connect.createStatement();
        return st.executeUpdate(sql) > 0;
    }
}
