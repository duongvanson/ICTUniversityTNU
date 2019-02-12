package thuchanh;
import java.awt.*;
import java.awt.event.*;
public class ViDuButton2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameBTN02 frm = new FrameBTN02();
		frm.setVisible(true);
	}

}
class FrameBTN02 extends Frame implements ActionListener{
	public FrameBTN02() {
		// TODO Auto-generated constructor stub
		super("VÍ DỤ BUTTON 02");
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		Button btn = new Button("Click here");
		btn.setSize(100, 50);
		Button btn2 = new Button("Click here 2");
		btn2.setSize(100, 50);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.print("Click button 2\n");
			}
		});
		btn.addActionListener(this);
		this.add(btn);
		this.add(btn2);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("Click button 1\n");
	}
	
}