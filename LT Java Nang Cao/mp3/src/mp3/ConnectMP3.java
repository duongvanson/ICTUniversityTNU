/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import java.sql.*;

/**
 *
 * @author dvson
 */
public class ConnectMP3 {
    String className = "com.mysql.jdbc.Driver";
    String host = "jdbc:mysql://localhost/mp3?useUnicode=yes&characterEncoding=UTF-8";
    String user = "root";
    String pass = "";
    String sheet = "baihat";
    Connection conn;
    public void initConnect(){
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(host, user, pass);
        } catch (Exception e) {
            System.out.println("mp3.ConnectMP3.initConnect()"+e.getMessage());
        }
    }
    public void closeConnect(){
        try {
            this.conn.close();
        } catch (Exception e) {
            System.out.println("mp3.ConnectMP3.closeConnect()"+e.getMessage());
        }
    }
    public ResultSet getAllMp3(){
        String query = "select * from "+this.sheet;
        ResultSet rs = null;
        try {
            Statement st = this.conn.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("mp3.ConnectMP3.getAllMp3()"+e.getMessage());
        }
        return rs;
    }
    public ResultSet getMp3(String mabh){
        String query = "select * from "+this.sheet+" where mabh = '"+mabh+"'";
        ResultSet rs = null;
        try {
            Statement st = this.conn.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("mp3.ConnectMP3.getAllMp3()"+e.getMessage());
        }
        return rs;
    }
    public boolean deleteMp3(String mabh){
        String query = "delete from "+this.sheet+" where mabh = '"+mabh+"'";
        try {
            Statement st = this.conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (Exception e) {
            System.out.println("mp3.ConnectMP3.getAllMp3()"+e.getMessage());
            return false;
        }
    }
    public boolean insertMp3(String ma, String ten, String tacgia, String nam){
        String query = "insert into baihat values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ma);
            ps.setString(2, ten);
            ps.setString(3, tacgia);
            ps.setString(4, nam);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean updateMp3(String ma, String ten, String tacgia, String nam){
        String query = "update baihat set tenbh=?,tacgia=?,namst=? where mabh=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(4, ma);
            ps.setString(1, ten);
            ps.setString(2, tacgia);
            ps.setString(3, nam);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
    }
}
