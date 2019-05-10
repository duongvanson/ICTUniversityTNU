/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khach;
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
    JPanel pnlMain, pnlTop, pnlCen, pnlBot;
    JButton btnAdd, btnEdit, btnDelete;
    JTextArea txtView;
    JTable tblView;
    DefaultTableModel dml;
    String [] arr = {"Mã", "Tên", "CMND", "Địa chỉ", "Thêm"};
    Model model;
    public GUI(){
        
        model = new Model();
        pnlTop = new JPanel();
        pnlTop.add(new JLabel("Khách hàng"));
        
        pnlCen = new JPanel();
        tblView = new JTable();
        pnlCen.add(new JScrollPane(tblView));
        
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
        pnlMain.add(pnlCen, BorderLayout.CENTER);
        pnlMain.add(pnlBot, BorderLayout.PAGE_END);
        
        getContentPane().add(pnlMain);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        pack();
    }
    public void loadData(){
        model.initData();
        dml = new DefaultTableModel();
        dml.setColumnIdentifiers(arr);
        
        ResultSet rs = model.getAll();
        try {
            while(rs.next()){
                String [] row = new  String[rs.getMetaData().getColumnCount()];
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                    row[i] = rs.getString(i+1);
                }
                dml.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblView.setModel(dml);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == btnEdit) {
            if (tblView.getSelectedRow() == -1) {
                showErr("Chưa chọn dòng nào");
            }else{
                String makhach = (String) tblView.getModel().getValueAt(tblView.getSelectedRow(), 0);
                try {
                    showEdit(makhach);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void showErr(String string) {
        JOptionPane.showMessageDialog(this, string);
    }

    private void showEdit(String makhach) throws SQLException {
        ResultSet khach = model.getKhach(makhach);
        khach.next();
        JTextField txtMa = new JTextField(khach.getString(1)),
                txtTen = new JTextField(khach.getString(2)),
                txtCMND = new JTextField(khach.getString(3)),
                txtDiaChi = new JTextField(khach.getString(4)),
                txtThem = new JTextField(khach.getString(5));
        txtMa.enable(false);
        JComponent [] gui = {
          new JLabel("Mã khách"),
            txtMa,
            new JLabel("Tên khách"),
            txtTen,
            new JLabel("CMND"),
            txtCMND,
            new JLabel("Địa chỉ"),
            txtDiaChi,
            new JLabel("Thêm"),
            txtThem
        };
        if (JOptionPane.showConfirmDialog(this, gui, "Sửa thông tin",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            if (!model.updateKhach(txtMa.getText(),
                    txtTen.getText(),
                    txtCMND.getText(),
                    txtDiaChi.getText(),
                    txtThem.getText())) {
                showErr("Lỗi sửa");
                
            }else{
                loadData();
            }
        }
    }
}
