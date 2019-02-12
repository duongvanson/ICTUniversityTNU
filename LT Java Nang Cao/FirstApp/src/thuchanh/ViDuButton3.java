package thuchanh;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.*;

public class ViDuButton3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameBTN03 frm = new FrameBTN03();
		frm.setVisible(true);
	}

}
class FrameBTN03 extends Frame implements ActionListener{
	public FrameBTN03() {
		// TODO Auto-generated constructor stub
		super("VÍ DỤ BUTTON 03");
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		Button btn = new Button("button01");
		btn.setSize(100, 50);
		Button btn2 = new Button("button02");
		btn2.setSize(100, 50);
		Button btn3 = new Button("button03");
		btn3.setSize(100, 50);
		btn.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		this.add(btn);
		this.add(btn2);
		this.add(btn3);
		
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
		switch (ae.getActionCommand()) {
		case "button01":
			System.out.println("Click 01");
			break;
		case "button02":
			System.out.println("Click 02");
			break;
		case "button03":
			System.out.println("Click 03");
			break;
		default:
			break;
		}
	}
	
}