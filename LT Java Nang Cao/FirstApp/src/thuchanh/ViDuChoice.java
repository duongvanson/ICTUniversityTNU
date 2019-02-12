package thuchanh;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ViDuChoice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameChoice frm = new FrameChoice();
		frm.setVisible(true);
	}

}
class FrameChoice extends Frame implements ItemListener, ActionListener{
	String hoQua, doUong;
	MenuItem mi1,mi2,sub1,sub2;
	public FrameChoice() {
		super("VÍ DỤ CHOICE - LIST - MENUBAR");
		this.setSize(500, 500);
		Choice ccHoaQua = new Choice();
		ccHoaQua.addItem("Táo");
		ccHoaQua.addItem("Lê");
		ccHoaQua.addItem("Đào");
		ccHoaQua.addItem("Chuối");
		Label lblChoice = new Label("CHỌN HOA QUẢ?");
		ccHoaQua.addItemListener(this);
		Label lblList = new Label("CHỌN ĐỒ UỐNG?");
		List lstDoUong = new List(3);
		lstDoUong.add("Cocacola");
		lstDoUong.add("Pesi");
		lstDoUong.add("Nước lọc");
		lstDoUong.add("Bia đen");
		lstDoUong.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				// TODO Auto-generated method stub
				doUong = lstDoUong.getSelectedItem();
			}
		});
		Button btnSubmit = new Button("XÁC NHẬN");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (lstDoUong.getSelectedIndex() == -1) {
					System.out.println("Bạn chưa chọn đồ uống.");
					return;
				}
				System.out.println("COMBO: "+ccHoaQua.getSelectedItem()+" & " + doUong);
			}
		});
		Menu menu1 = new Menu("Tùy chọn");
		mi1 = new MenuItem("Chức năng 1");
		mi2 = new MenuItem("Chức năng 2");
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		menu1.add(mi1);
		menu1.add(mi2);
		menu1.addSeparator();
		Menu subMenu = new Menu("Tùy chọn khác");
		sub1 = new MenuItem("Nền đỏ");
		sub2 = new MenuItem("Nền xanh");
		sub1.addActionListener(this);
		sub2.addActionListener(this);
		subMenu.add(sub1);
		subMenu.add(sub2);
		menu1.add(subMenu);
		
		MenuBar menuBar = new MenuBar();
		menuBar.add(menu1);
		
		this.setMenuBar(menuBar);
		this.setLayout(new FlowLayout());
		this.add(lblChoice);
		this.add(ccHoaQua);
		this.add(lblList);
		this.add(lstDoUong);
		this.add(btnSubmit);
		//CLOSE
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stub
		hoQua = ie.getItem().toString();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		MenuItem mnu = (MenuItem) ae.getSource();
		if (mnu == mi1) {
			System.out.println("Chức năng 1 được chọn.");
		}
		if (mnu == mi2) {
			System.out.println("Chức năng 2 được chọn.");
		}
		if (mnu == sub1) {
			this.setBackground(Color.red);
		}
		if (mnu == sub2) {
			this.setBackground(Color.green);
		}
	}
}
