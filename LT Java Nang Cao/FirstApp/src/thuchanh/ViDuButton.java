package thuchanh;
import java.awt.*;
import java.awt.event.*;
public class ViDuButton {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameBTN frm = new FrameBTN();
		frm.setVisible(true);
	}

}
class FrameBTN extends Frame implements ActionListener{
	public FrameBTN() {
		// TODO Auto-generated constructor stub
		super("VÍ DỤ BUTTON");
		this.setSize(500,500);
		Button btn = new Button("Click here");
		btn.addActionListener(this);
		this.add(btn);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("Click button\n");
	}
	
}