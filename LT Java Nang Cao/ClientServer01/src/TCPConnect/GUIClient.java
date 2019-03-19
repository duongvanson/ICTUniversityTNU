package TCPConnect;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import TCPConnect.*;

public class GUIClient extends JFrame{
	public GUIClient() throws Exception{
		TCPClient client = new TCPClient();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		JLabel lblTitle = new JLabel("Send SERVER");
		JTextArea txtView = new JTextArea();
		JPanel pnlBot = new JPanel();
		pnlBot.setLayout(new BorderLayout());
		JLabel lblSub = new JLabel("Messge");
		JTextField txtMess = new JTextField();
		
		JButton btnSend = new JButton("Send");
		pnlBot.add(lblSub, BorderLayout.WEST);
		pnlBot.add(txtMess, BorderLayout.CENTER);
		pnlBot.add(btnSend, BorderLayout.EAST);
		
		btnSend.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String mess = txtMess.getText().trim();
				txtView.append("CLIENT: "+mess+"\n");
				try {
					String result = client.sendServer(mess);
					txtView.append("SERVER: "+result+"\n");
					txtMess.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		pnlMain.add(lblTitle, BorderLayout.PAGE_START);
		pnlMain.add(txtView, BorderLayout.CENTER);
		pnlMain.add(pnlBot, BorderLayout.PAGE_END);
		
		this.getContentPane().add(pnlMain);
		this.pack();
		this.setSize(500, 500);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new GUIClient();
	}

}
