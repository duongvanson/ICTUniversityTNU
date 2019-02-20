package gui;
import java.awt.*;
import model.*;
import java.sql.*;
import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
public class MainPage extends JFrame implements ActionListener{
        TextField txtID, txtName, txtSex, txtAddress;
	JButton btnAdd, btnUpdate, btnDelete;
	JPanel titlePnl, tablePnl, btnPnl, infoPnl, botPnl;
	JPanel mainPnl;
	static JTable table;
	String col[] = {"ID", "Họ và tên", "Giới tính","Địa chỉ"};
	static DefaultTableModel tableModel = new DefaultTableModel();
        static ConnectData connectData;
	MainPage(){
                connectData = new ConnectData();
		//Title
		titlePnl = new JPanel();
		titlePnl.add(new Label("Quản lý thành viên"));
		//Table Students
                tableModel.setColumnIdentifiers(col);
		table = new JTable();
		tablePnl = new JPanel();
		tablePnl.add(new JScrollPane(table));
		//Button
		btnAdd = new JButton("Add");
                btnAdd.addActionListener(this);
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnPnl = new JPanel();
		btnPnl.add(btnAdd);
		btnPnl.add(btnUpdate);
		btnPnl.add(btnDelete);
                //ADD UPDATE DELETE
                infoPnl = new JPanel();
                infoPnl.setLayout(new GridLayout(4,2));
                txtID = new TextField(10);
                txtName = new TextField(10);
                txtSex = new TextField(10);
                txtAddress = new TextField(10);
                infoPnl.add(new Label("ID "));
                infoPnl.add(txtID);
                infoPnl.add(new Label("NAME "));
                infoPnl.add(txtName);
                infoPnl.add(new Label("SEX "));
                infoPnl.add(txtSex);
                infoPnl.add(new Label("ADDRESS "));
                infoPnl.add(txtAddress);
		//
                botPnl = new JPanel();
                botPnl.setLayout(new BorderLayout());
                botPnl.add(btnPnl, BorderLayout.PAGE_START);
                botPnl.add(infoPnl, BorderLayout.PAGE_END);
                //
		mainPnl = new JPanel();
		mainPnl.setLayout(new BorderLayout());
		mainPnl.add(titlePnl, BorderLayout.PAGE_START);
		mainPnl.add(tablePnl, BorderLayout.CENTER);
		mainPnl.add(botPnl, BorderLayout.PAGE_END);
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPnl);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainPage();
                connectData.initConnect();
                loadDataToTable();
                
                connectData.closeConn();
	}
	public static void loadDataToTable(){
            ResultSet rs = connectData.getData();
            List<String> row;
            try {
                while(rs.next()){
                row = new ArrayList<String>();
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i+1));
                }
                tableModel.addRow(row.toArray());
            }
            } catch (SQLException e) {
                e.getStackTrace();
            }
            table.setModel(tableModel);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == btnAdd) {
            String name = txtName.getText();
            String sex = txtSex.getText();
            String address = txtAddress.getText();
            if(connectData.addStudent(name, sex, address))
                System.out.println("OK add");
        }
        connectData.closeConn();
    }
}
