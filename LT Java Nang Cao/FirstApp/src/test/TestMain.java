package test;
import java.awt.*;
import java.applet.*;
@SuppressWarnings("unused")
public class TestMain extends Applet{
	@Override
	public void paint(Graphics g) {
		this.setSize(800, 800);
		int x = 100, y = 100, check =0;
		g.drawLine(50, 50, 50,200);
		g.setColor(Color.red);
		g.drawLine(50, 50,200,50);
		//g.drawLine(30, 85, 30, 500);
//		for (int i = 0; i < 10; i++) {
//			if(check == 0) {
//				
//				g.setColor(Color.red);
//				//g.drawOval(x, y, 200, 200);
//				g.drawRect(x, y, 200, 200);
//				check = 1;
//			}
//			if(check == 1) {
//				
//				g.setColor(Color.green);
//				//g.fillOval(x, y, 200, 200);
//				g.fillRect(x, y, 200, 200);
//				check = 0;
//			}
//			x+=30;
//			y+=30;
//		}
//		for (int i = 0; i < 5; i++) {
//			g.drawLine(x, y, x,y+100);
//			g.setColor(Color.red);
//			g.drawLine(x, y,y+100,x);
//			//g.drawRect(x, y, 200, 200);
//			x+=20;
//			y-=20;
//		}
//		for (int i = 0; i < 5; i++) {
//			g.drawLine(x, y, x,y+100);
//			g.setColor(Color.red);
//			g.drawLine(x, y,y+100,x);
//			//g.drawRect(x, y, 200, 200);
//			x-=20;
//			y+=20;
//		}
		// TODO Auto-generated method stub
//		g.setColor(Color.GREEN);
//		g.drawString("First app", this.getWidth()/2, this.getHeight()/2);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font fonts[] = ge.getAllFonts();
		for (int i = 0; i < fonts.length; i++) {
			g.setFont(new Font(fonts[i].getFontName(), Font.BOLD, 16));
			g.drawString(fonts[i].getFontName(), 200, x+=30);
		}
	}
	@Override
	public void init() {
		Panel pnl = new Panel();
		pnl.setSize(this.getWidth(), this.getHeight());
		pnl.setBackground(Color.gray);
		Button btn = new Button("Click me");
		btn.setSize(50, 100);
		pnl.add(btn);
		this.add(pnl);
	}
}
