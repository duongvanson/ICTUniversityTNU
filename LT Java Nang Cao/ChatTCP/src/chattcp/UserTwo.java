/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattcp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class UserTwo extends JFrame{
    JPanel pnlMain = new JPanel(),
        pnlTop = new JPanel(),
        pnlView = new JPanel(),
        pnlBot = new JPanel();
    JButton  btnSend = new JButton("Send");
    JTextArea txtContent = new JTextArea(20, 30);
    JTextField txtMess = new JTextField(20);
    Timer t;
    public Socket clientSocket;
    private BufferedReader nhan;
    private DataOutputStream gui;
    public UserTwo() throws IOException{
        clientSocket = new Socket("duongson-pc",3198);
        nhan = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        gui = new DataOutputStream(clientSocket.getOutputStream());
        
        pnlTop.add(new JLabel("USER TWO"));
        pnlView.setLayout(new BorderLayout());
        pnlView.add(txtContent, BorderLayout.CENTER);
        
        pnlBot.setLayout(new BorderLayout());
        pnlBot.add(txtMess,BorderLayout.CENTER);
        pnlBot.add(btnSend, BorderLayout.EAST);
        
        btnSend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String mess =txtMess.getText().toString().trim();
                //if(!mess.equals("")){
                    try {
                    if(!mess.equals("")) gui.writeBytes("ONE: " + mess+"\n");
                    else gui.writeBytes("\n");
                    //txtContent.append("TWO: "+mess+"\n");
                    txtContent.setText(nhan.readLine().replace('%', '\n')+"\n");
                    } catch (IOException ex) {
                    Logger.getLogger(UserOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                //}
                txtMess.setText("");
            }
        });
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtMess.getText().equals("")) btnSend.doClick();
            }
        });
        t.start();
        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(pnlTop, BorderLayout.PAGE_START);
        pnlMain.add(pnlView, BorderLayout.CENTER);
        pnlMain.add(pnlBot, BorderLayout.PAGE_END);
        
        this.setSize(400,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        pack();
        this.setLocation(800, 50);
        setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        new UserTwo();
    }
}
