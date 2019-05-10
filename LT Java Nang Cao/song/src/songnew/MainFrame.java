package songnew;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dvson
 */
public class MainFrame extends JFrame implements ActionListener{
    JPanel pnlMain, pnlTop, pnlCenter, pnlBot;
    JButton btnAdd, btnEdit, btnDelete;
    JTable tblView;
    DefaultTableModel tblModel;
    String [] arrTitle = {"ID","Name","Author","Year"};
    Model model = new Model();
    public MainFrame(){
        pnlTop = new JPanel();
        pnlTop.add(new JLabel("List song"));
        
        pnlCenter = new JPanel();
        tblView = new JTable();
        pnlCenter.add(new JScrollPane(tblView));
        
        pnlBot = new JPanel();
        btnAdd = new JButton("ADD");
        btnAdd.addActionListener(this);
        btnEdit = new JButton("EDIT");
        btnEdit.addActionListener(this);
        btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(this);
        pnlBot.add(btnAdd);
        pnlBot.add(btnEdit);
        pnlBot.add(btnDelete);
        
        pnlMain = new JPanel(new BorderLayout());
        pnlMain.add(pnlTop, BorderLayout.PAGE_START);
        pnlMain.add(pnlCenter, BorderLayout.CENTER);
        pnlMain.add(pnlBot, BorderLayout.PAGE_END);
        
        setVisible(true);
        getContentPane().add(pnlMain);
        setSize(400,500);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == btnAdd) {
            try {
                showAdd();
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (btn == btnEdit) {
            if (tblView.getSelectedRow() == -1) {
                showErr("Chưa chọn gì cả");
            }else{
                String id = (String) tblView.getModel().getValueAt(tblView.getSelectedRow(), 0);
                try {
                    showEdit(id);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(btn == btnDelete){
            if (tblView.getSelectedRow() == -1) {
                showErr("Chưa chọn gì cả");
            }else{
                String id = (String) tblView.getModel().getValueAt(tblView.getSelectedRow(), 0);
                try {
                    showDelete(id);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void loadData() throws ClassNotFoundException, SQLException{
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(arrTitle);
        
        model.initData();
        ResultSet rs = model.getAll("song");
        while (rs.next()) {            
            String [] data = new String[rs.getMetaData().getColumnCount()];
            for(int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                data[i] = rs.getString(i+1);
            }
            tblModel.addRow(data);
         }
        //tblModel.addRow(arrTitle);
        //System.out.println(tblModel.getColumnCount());
        tblView.setModel(tblModel);
    }
    private void showErr(String err){
        JOptionPane.showMessageDialog(this, err);
    }
    private void showAdd() throws SQLException, ClassNotFoundException {
        JTextField txtID = new JTextField(),
                txtName = new JTextField(),
                txtAuthor = new JTextField(),
                txtYear = new JTextField();
        JComponent [] gui = {
            new JLabel("ID"),
            txtID,
            new JLabel("Name"),
            txtName,
            new JLabel("Author"),
            txtAuthor,
            new JLabel("Year"),
            txtYear,
        };
        if (JOptionPane.showConfirmDialog(this, gui, "ADD SONG",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            if(!model.insertSong("0", txtName.getText(), txtAuthor.getText(), txtYear.getText())){
                showErr("Thêm thất bại");
            }else{
                loadData();
            }
        }
    }

    private void showEdit(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = model.getSong(Integer.parseInt(id));
        rs.next();
        JTextField txtID = new JTextField(rs.getString(1)),
                txtName = new JTextField(rs.getString(2)),
                txtAuthor = new JTextField(rs.getString(3)),
                txtYear = new JTextField(rs.getString(4));
        JComponent [] gui = {
            new JLabel("ID"),
            txtID,
            new JLabel("Name"),
            txtName,
            new JLabel("Author"),
            txtAuthor,
            new JLabel("Year"),
            txtYear,
        };
        if (JOptionPane.showConfirmDialog(this, gui, "EDIT SONG",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            if(!model.updateSong(id, txtName.getText(), txtAuthor.getText(), txtYear.getText())){
                showErr("Sửa thất bại");
            }else{
                loadData();
            }
        }
    }

    private void showDelete(String id) throws SQLException, ClassNotFoundException {
        if (JOptionPane.showConfirmDialog(this, "Xóa Song có ID "+ id,"Thông báo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            if(!model.deleteSong(id)){
                showErr("Xóa thất bại");
            }else{
                loadData();
            }    
        }
    }


}
