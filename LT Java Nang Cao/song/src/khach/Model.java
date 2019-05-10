/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khach;
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
    public void initData(){
        String nameclass = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "";
        String database = "jdbc:mysql://localhost:3306/khachhang?characterEncoding=UTF-8";
        try {
            connect = DriverManager.getConnection(database, user, pass);
            System.out.println("OK");
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getAll(){
        sql = "select * from khach";
        Statement st;
        try {
            st = connect.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet getKhach(String makhach){
        sql = "select * from khach where makhach = '"+makhach+"'";
        Statement st;
        try {
            st = connect.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean updateKhach(String ma, String ten, String cmnd, String diachi, String them) throws SQLException{
        sql = "update khach set tenkhach=?, cmnd=?, diachi=?, thongtinthem=? where makhach=?";
        ps = connect.prepareStatement(sql);
        ps.setString(1, ten);
        ps.setString(2, cmnd);
        ps.setString(3, diachi);
        ps.setString(4, them);
        ps.setString(5, ma);
        return ps.executeUpdate() > 0;
    }
}
