/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dvson
 */
public class GUI extends JFrame implements ActionListener{
    JPanel pnlMain, pnlTop, pnlCenter, pnlBot;
    static JTable tblView;
    DefaultTableModel tblModel;
    JButton btnAdd, btnEdit, btnDelete;
    String [] title = {"Mã", "Tên", "Hãng", "Số lượng","Giá"};
    Model model = new Model();
    public GUI(){
        pnlTop = new JPanel();
        pnlTop.add(new JLabel("DANH SÁCH HÀNG"));
        
        pnlCenter = new JPanel();
        tblView = new JTable();
        pnlCenter.add(new JScrollPane(tblView));
        
        pnlBot = new JPanel();
        btnAdd = new JButton("ADD");
        btnEdit = new JButton("EDIT");
        btnDelete = new JButton("DELETE");
        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        pnlBot.add(btnAdd);
        pnlBot.add(btnEdit);
        pnlBot.add(btnDelete);
        
        pnlMain = new JPanel(new BorderLayout());
        pnlMain.add(pnlTop, BorderLayout.PAGE_START);
        pnlMain.add(pnlCenter, BorderLayout.CENTER);
        pnlMain.add(pnlBot, BorderLayout.PAGE_END);
        getContentPane().add(pnlMain);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    public void loadData() throws SQLException{
        model.initData();
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(title);
        try {
            ResultSet rs = model.getHang();
            while(rs.next()){
                String [] row = new String[rs.getMetaData().getColumnCount()];
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                    row[i] = rs.getString(i+1);
                }
                tblModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblView.setModel(tblModel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn == btnAdd){
            try {
                showAdd();
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showAdd() throws SQLException {
        JTextField txtMa = new JTextField(),
                txtTen = new JTextField(),
                txtHang = new JTextField(),
                txtSoLuong = new JTextField(),
                txtGia = new JTextField();
        JComponent [] gui = {
            new JLabel("Mã"),
            txtMa,
            new JLabel("Tên"),
            txtTen,
            new JLabel("Hãng"),
            txtHang,
            new JLabel("Số lượng"),
            txtSoLuong,
            new JLabel("Giá"),
            txtGia,
        };
        if(JOptionPane.showConfirmDialog(this, gui, "Thêm hàng", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
            if(!model.insertHang(txtMa.getText(),
                    txtTen.getText(),
                    txtHang.getText(),
                    txtSoLuong.getText(),
                    txtGia.getText())){
                showErr("Lỗi thêm");
            }else{
                loadData();
            }
        }
    }

    private void showErr(String err) {
        JOptionPane.showMessageDialog(this, err);
    }
}
