package tcpjava;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author dvson
 */
public class VClientGUI extends JFrame{
    public static Socket client;
    public static BufferedReader nhanServer;
    public static DataOutputStream guiServer;
    JPanel pnlMain, pnlTop, pnlCenter, pnlBot;
    JTextArea txtView;
    JTextField txtSend;
    JButton btnSend;
    public VClientGUI(){
        try {
            client = new Socket(InetAddress.getLocalHost().getHostName(), 3198);
            nhanServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            guiServer = new DataOutputStream(client.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(VClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        pnlTop = new JPanel();
        pnlTop.add(new JLabel("CLIENT"));
        
        //pnlCenter = new JPanel();
        txtView = new JTextArea();
        txtView.enable(false);
        //pnlCenter.add(txtView);
        
        pnlBot = new JPanel(new BorderLayout());
        txtSend = new JTextField();
        txtSend.setSize(100, 20);
        btnSend = new JButton("SEND");
        pnlBot.add(new JLabel("Mess: "), BorderLayout.WEST);
        pnlBot.add(txtSend, BorderLayout.CENTER);
        pnlBot.add(btnSend, BorderLayout.EAST);
        
        pnlMain = new JPanel(new BorderLayout());
        pnlMain.add(pnlTop, BorderLayout.PAGE_START);
        pnlMain.add(txtView, BorderLayout.CENTER);
        pnlMain.add(pnlBot, BorderLayout.PAGE_END);
        
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nhan;
                try {
                    String mess = txtSend.getText();
                    guiServer.writeBytes(mess+"\n");
                    nhan = nhanServer.readLine();
                    txtView.append(nhan+"\n");
                } catch (IOException ex) {
                    Logger.getLogger(VClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(pnlMain);
        setVisible(true);
        pack();
        setSize(400,400);
    }
    
    public static void main(String[] args) {
        VClientGUI vClientGUI = new VClientGUI();
    }
}
