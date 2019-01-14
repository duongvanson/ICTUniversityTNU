package test;
import java.awt.*;
public class FrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frm = new Frame("First frame");
		frm.setSize(300,450);
		frm.setVisible(true);
		//frm.show();
		Dialog dl = new Dialog(frm, "Luolio",true);
		dl.setSize(200, 200);
		//dl.setVisible(true);
	}

}
