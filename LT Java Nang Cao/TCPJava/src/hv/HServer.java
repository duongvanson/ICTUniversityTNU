/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hv;
import java.awt.*;
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
class Data{
    public static String data = "";
}
class ClientX extends Thread{

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(3198);
            Socket client = server.accept();
            System.out.println("+1");
            DataOutputStream guiClient = new DataOutputStream(client.getOutputStream());
            BufferedReader nhanClient = new BufferedReader(
            new InputStreamReader(client.getInputStream()));
            
            while(true){
                String nhan = nhanClient.readLine();
                String [] arr = nhan.split(" ");
                Data.data += "("+nhan+")\n";
                guiClient.writeBytes("Dien tich= "+ (
                        Double.parseDouble(arr[0])*Double.parseDouble(arr[1]))+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
public class HServer extends JFrame{
    public HServer(){
        setLayout(new BorderLayout());
        JButton btn = new JButton("Khởi động");
        JTextArea txtView = new JTextArea();
        JLabel lbl = new JLabel("...");
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Server đã chạy");
                ClientX cx = new ClientX();
                cx.start();
            }
        });
        
        Timer t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Data.data.equals(txtView.getText())){
                    txtView.setText(Data.data);
                }
            }
        });
        t.start();
        getContentPane().add(btn, BorderLayout.PAGE_START);
        getContentPane().add(txtView, BorderLayout.CENTER);
        getContentPane().add(lbl, BorderLayout.PAGE_END);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
    }
    public static void main(String[] args) {
        new HServer();
    }
}
