/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dvson
 */
public class Mp3 extends JFrame implements ActionListener{
    static ConnectMP3 conn;
    static JTable tblView = new JTable();
    static DefaultTableModel tblModel = new DefaultTableModel();

    String colName[] = {"Mã BH","Tên BH","Tác giả","Năm ST"};
    //Panel
    JPanel pnlMain = new JPanel(),
           pnlTop = new JPanel(),
           pnlBot = new JPanel(),
           pnlMid = new JPanel();
    JButton btnAdd = new JButton("Add new"),
            btnDelete = new JButton("Delete"),
            btnEdit = new JButton("Edit");
    //Creater object MP3
    public Mp3(){
        this.conn = new ConnectMP3();
        //Title
        pnlTop.add(new JLabel("Danh sách bài hát"));
        //Mid table
        tblModel.setColumnIdentifiers(colName);
        pnlMid.add(new JScrollPane(tblView));
        //Bot panel
        pnlBot.setLayout(new FlowLayout());
        pnlBot.add(btnAdd);
        pnlBot.add(btnEdit);
        pnlBot.add(btnDelete);
        //add Main View
        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(pnlTop, BorderLayout.PAGE_START);
        pnlMain.add(pnlMid, BorderLayout.CENTER);
        pnlMain.add(pnlBot, BorderLayout.PAGE_END);
        tblView.setEnabled(false);
        ///
        this.setSize(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        pack();
        setVisible(true);
        //Ađ envent
        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
    }
    public static void main(String[] args) {
        new Mp3();
        conn.initConnect();
        loadDataToTabel();
    }
    public static void loadDataToTabel(){
        tblView.removeAll();
        ResultSet rs = conn.getAllMp3();
        try {
            List<String> row;
            while (rs.next()) {                
                row = new ArrayList<String>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                tblModel.addRow(row.toArray());
            }
            tblView.setModel(tblModel);
        } catch (Exception e) {
            System.out.println("mp3.Mp3.loadDataToTabel()"+e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == btnAdd) {
            showInsertAndUpdate("");
            //frmInsert frm = new frmInsert();
            //frm.setVisible(true);
        }
        if (btn == btnEdit) {
            if (tblView.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Chưa chọn gì cả.","CLGT",JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                String mabh =  tblView.getModel().getValueAt(tblView.getSelectedRow(), 0).toString();
                showInsertAndUpdate(mabh);
            }
            showInsertAndUpdate("update");
        }
        if (btn == btnDelete) {
            if (tblView.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Chưa chọn gì cả.","CLGT",JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                int rs = JOptionPane.showConfirmDialog(this, "Xác nhận xóa","Thông báo",JOptionPane.OK_CANCEL_OPTION);
                String mabh =  tblView.getModel().getValueAt(tblView.getSelectedRow(), 0).toString();
                if (rs == JOptionPane.OK_OPTION) {
                    if (!conn.deleteMp3(mabh)) {
                        JOptionPane.showMessageDialog(this, "Xóa thất bại.","CLGT",JOptionPane.ABORT);
                    }else{
                        JOptionPane.showMessageDialog(this, "Xóa thành công.","CLGT",JOptionPane.OK_OPTION);
                    }
                }
            }
        }
        loadDataToTabel();
    }
    public void showInsertAndUpdate(String ctrl){
        JTextField txtMa = new JTextField(),
                txtTen = new JTextField(),
                txtTacGia =  new JTextField(),
                txtNamST = new JTextField();
        JComponent[] view = new JComponent[]{
            new JLabel("Mã BH"), txtMa,
            new JLabel("Tên BH"), txtTen,
            new JLabel("Tác giả BH"), txtTacGia,
            new JLabel("Năm ST BH"), txtNamST,
        };
        if(ctrl == ""){
            int rsd = JOptionPane.showConfirmDialog(this, view, "Thêm bài hát mới", JOptionPane.DEFAULT_OPTION);
            if (rsd == 0) {
                if (!conn.insertMp3(txtMa.getText(), txtTen.getText(), txtTacGia.getText(), txtNamST.getText())) {
                    JOptionPane.showConfirmDialog(this, "Thêm thất bại","Thông báo", JOptionPane.DEFAULT_OPTION);
                    showInsertAndUpdate("");
                }
            }
        }else{
            ResultSet rs = conn.getMp3(ctrl);
            try {
                rs.next();
                txtMa.setText(rs.getString(1));
                //System.out.println("mp3.Mp3.showInsertAndUpdate(): "+rs.getString(2));
                txtTen.setText(rs.getString(2));
                txtTacGia.setText(rs.getString(3));
                txtNamST.setText(rs.getString(4));
                txtMa.setEnabled(false);
                int rsd = JOptionPane.showConfirmDialog(this, view, "Sửa bài hát: "+txtTen.getText(), JOptionPane.DEFAULT_OPTION);
                if (rsd == 0) {
                    if (!conn.updateMp3(txtMa.getText(), txtTen.getText(), txtTacGia.getText(), txtNamST.getText())) {
                        JOptionPane.showConfirmDialog(this, "Sửa thất bại","Thông báo", JOptionPane.DEFAULT_OPTION);
                }
            }
            } catch (Exception e) {
                System.out.println("mp3.Mp3.showInsertAndUpdate()");
            }
            
            
        }
    }
}
class frmInsert extends JFrame{
    public frmInsert() {
        JPanel pnlMain = new JPanel();
        
        JLabel title = new JLabel("Thêm mới");
        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(title, BorderLayout.PAGE_START);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        setSize(300,300);
        setVisible(true);
    }
}
