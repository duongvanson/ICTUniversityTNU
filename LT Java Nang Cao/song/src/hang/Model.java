
package hang;
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
    public void initData() throws SQLException{
        String classname = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "";
        String database = "jdbc:mysql://localhost/hang";
        try {
            Class.forName(classname);
            connect = DriverManager.getConnection(database, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean insertHang(String ma, String ten, String hang, String soluong, String gia) throws SQLException{
        sql = "insert into mathang values(?,?,?,?,?)";
        ps = connect.prepareStatement(sql);
        ps.setString(1, ma);
        ps.setString(2, ten);
        ps.setString(3, hang);
        ps.setString(4, soluong);
        ps.setString(5, gia);
        try {
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    public ResultSet getHang() throws SQLException{
        sql = "select * from mathang";
        ps = connect.prepareStatement(sql);
        return ps.executeQuery();
    }
}
