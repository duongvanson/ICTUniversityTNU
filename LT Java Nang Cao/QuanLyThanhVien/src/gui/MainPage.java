package gui;
import java.awt.*;
import model.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
public class MainPage extends JFrame {
	JButton btnAdd, btnUpdate, btnDelete;
	JPanel titlePnl, tablePnl, btnPnl;
	JPanel mainPnl;
	JTable table;
	String col[] = {"ID", "Họ và tên", "Giới tính","Địa chỉ"};
	DefaultTableModel tableModel = new DefaultTableModel();
	MainPage(){
		//Title
		titlePnl = new JPanel();
		titlePnl.add(new Label("Quản lý thành viên"));
		//Table Students
		table = new JTable();
		tablePnl = new JPanel();
		tablePnl.add(new JScrollPane(table));
		//Button
		btnAdd = new JButton("Add");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnPnl = new JPanel();
		btnPnl.add(btnAdd);
		btnPnl.add(btnUpdate);
		btnPnl.add(btnDelete);
		//
		mainPnl = new JPanel();
		mainPnl.setLayout(new BorderLayout());
		mainPnl.add(titlePnl, BorderLayout.PAGE_START);
		mainPnl.add(tablePnl, BorderLayout.CENTER);
		mainPnl.add(btnPnl, BorderLayout.PAGE_END);
		setContentPane(mainPnl);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainPage();
		ConnectData cd = new ConnectData();
		cd.initConnect();
	}
	public void loadDataToTable() {
		
	}
}

