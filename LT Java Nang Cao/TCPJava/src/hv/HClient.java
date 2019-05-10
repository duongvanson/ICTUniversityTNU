/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hv;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dvson
 */
public class HClient extends JFrame{
    Socket client;
    DataOutputStream guiServer;
    BufferedReader nhanServer;
    public HClient() throws IOException{
        
        try {
            client = new Socket(InetAddress.getLocalHost().getHostName(), 3198);
            guiServer = new DataOutputStream(client.getOutputStream());
            nhanServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (UnknownHostException ex) {
            Logger.getLogger(HClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JLabel lblDai = new JLabel("Chieu dai: "),
                lblRong = new JLabel("Chieu rong: ");
        JTextField txtDai = new JTextField(),
                txtRong = new JTextField();
        JButton btnOK = new JButton("Gui server");
        JLabel lblView = new JLabel("...");
        
        lblDai.setBounds(20,50,100,30);
        txtDai.setBounds(20,80,200,30);
        lblRong.setBounds(20,110,100,30);
        txtRong.setBounds(20,140,200,30);
        btnOK.setBounds(20,190,100,30);
        lblView.setBounds(20, 220, 200, 30);
        
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gui = txtDai.getText()+" "+txtRong.getText();
                try {
                    guiServer.writeBytes(gui+"\n");
                    String nhan = nhanServer.readLine();
                    lblView.setText(nhan);
                    txtDai.setText("");
                    txtRong.setText("");
                } catch (IOException ex) {
                    Logger.getLogger(HClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        getContentPane().add(lblDai);
        getContentPane().add(txtDai);
        getContentPane().add(lblRong);
        getContentPane().add(txtRong);
        getContentPane().add(btnOK);
        getContentPane().add(lblView);
        setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(300,300);
    }
    public static void main(String[] args) throws IOException {
        new HClient();
    }
}
