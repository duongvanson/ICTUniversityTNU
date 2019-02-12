package thuchanh;

import java.awt.*;

public class layoutflow {
	
	public static void main(String[] args){
		abc f = new abc();
		f.setVisible(true);
		// TODO Auto-generated method stub
//		Frame fMain = new Frame("MAIN FRAME");
//		fMain.setSize(300, 500);
//		fMain.setLayout(new FlowLayout());
//		for (int i = 0; i < 10; i++) {
//			Button btn = new Button("Button "+i);
//			btn.setSize(100, 50);
//			fMain.add(btn);
//		}
//		fMain.setVisible(true);
	}

}
class abc extends Frame{
	public abc() {
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
