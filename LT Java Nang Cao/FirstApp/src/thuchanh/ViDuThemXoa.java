package thuchanh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViDuThemXoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameThemXoa frm = new FrameThemXoa();
		frm.setVisible(true);
	}

}
class FrameThemXoa extends Frame implements ActionListener{
	Button btnNext, btnPre, btnNextAll, btnPreAll, btnAdd;
	List lstA, lstB;
	TextField txtAdd;
	Label lblInfo = new Label();
	public FrameThemXoa() {
		// TODO Auto-generated constructor stub
		super("THÊM - SỬA - XÓA");
		this.setSize(500, 500);
		this.setLayout(new GridLayout(2,1));
		lstA = new List(10);
		for (int i = 1; i <= 10; i++) {
			lstA.add("Sản phẩm "+ i);
		}
		lstB = new List(10);
		btnNext = new Button(">");
		btnNextAll = new Button(">>");
		btnPre = new Button("<");
		btnPreAll = new Button("<<");
		Panel pnl = new Panel(new GridLayout(4, 1,5,5));
		pnl.add(btnNext);
		pnl.add(btnNextAll);
		pnl.add(btnPre);
		pnl.add(btnPreAll);
		
		Panel pnlTop = new Panel();
		pnlTop.setLayout(new FlowLayout());
		pnlTop.add(lstA);
		pnlTop.add(pnl);
		pnlTop.add(lstB);
		
		Panel pnlBottom = new Panel();
		pnlBottom.setLayout(new FlowLayout());
		txtAdd = new TextField(25);
		btnAdd = new Button("Add item list A");
		
		pnlBottom.add(txtAdd);
		pnlBottom.add(btnAdd);
		pnlBottom.add(lblInfo);
		
		//add events
		btnAdd.addActionListener(this);
		btnNext.addActionListener(this);
		btnNextAll.addActionListener(this);
		btnPre.addActionListener(this);
		btnPreAll.addActionListener(this);
		
		this.add(pnlTop);
		this.add(pnlBottom);
		//close
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Button btn = (Button) ae.getSource();
		//add
		if (btn == btnAdd) {
			String item = txtAdd.getText();
			if (item.trim().isEmpty()) {
				lblInfo.setForeground(Color.RED);
				lblInfo.setSize(100,30);
				lblInfo.setText("Item rỗng");
			}else {
				lstA.add(item);
			}
		}
		//next
		if (btn == btnNext) {
			String item = lstA.getSelectedItem();
			lstB.add(item);
			lstA.remove(lstA.getSelectedIndex());
		}
		//Next all
		if (btn == btnNextAll) {
			String[] item = lstA.getSelectedItems();
			For
			lstA.removeAll();
		}
		//Pre
		if (btn == btnPre) {
			String item = lstB.getSelectedItem();
			lstA.add(item);
			lstB.remove(lstB.getSelectedIndex());
		}
	}
}
