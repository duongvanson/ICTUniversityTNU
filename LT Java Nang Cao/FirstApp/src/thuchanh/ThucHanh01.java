package thuchanh;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class FrameButton extends Frame {
	public FrameButton() {
		super("MAIN FRAME");
		this.setSize(300, 500);
		this.setLayout(new FlowLayout());
		for (int i = 0; i < 10; i++) {
			Button btn = new Button("Button "+i);
			btn.setSize(100, 50);
			this.add(btn);
		}
	}
}
public class ThucHanh01 {
	public static void main(String[] args) {
		Button btnBai1 = new Button("Bài 1");
		btnBai1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FrameButton frm01 = new FrameButton();
				frm01.setVisible(true);
			}
		});
		// TODO Auto-generated method stub
		Frame fmain = new Frame();
		fmain.setSize(500, 500);
		fmain.setLayout(new FlowLayout());
		fmain.add(btnBai1);
		fmain.setVisible(true);
	}

}
