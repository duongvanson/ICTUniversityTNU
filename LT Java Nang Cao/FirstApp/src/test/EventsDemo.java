package test;

import java.awt.*;

public class EventsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frm = new Frame();
		frm.setSize(500, 500);
		Panel pnl = new Panel();
		pnl.setSize(500,500);
		TextField txtA = new TextField();
		txtA.setSize(50,100);
		pnl.add(txtA);
		frm.add(pnl);
		frm.setVisible(true);
	}

}
