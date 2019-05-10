/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpjava;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
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
class TClient extends Thread{

    @Override
    public void run() {
        ServerSocket server;
        DataOutputStream guiClient;
        BufferedReader nhanClient;
        try {
            server = new ServerSocket(3198);
            Socket client = server.accept();
            System.out.println("tcpjava.TClient.run()");
            guiClient = new DataOutputStream(client.getOutputStream());
            nhanClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while(true){
                String nhan = nhanClient.readLine();
                Data.data += nhan + "\n";
                System.out.println("C: " + nhan);
                guiClient.writeBytes("Phan hoi tu server\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(VServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
public class VServer extends JFrame{
    public VServer(){
        JPanel pnlMain = new JPanel(new BorderLayout());
        JButton btnStart = new JButton("Khởi động");
        JLabel lblStaus = new JLabel("...");
        JTextArea txtView = new JTextArea();
        txtView.enable(false);
        pnlMain.add(btnStart, BorderLayout.PAGE_START);
        pnlMain.add(txtView, BorderLayout.CENTER);
        pnlMain.add(lblStaus, BorderLayout.PAGE_END);
        
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblStaus.setText("OK");
                TClient client = new TClient();
                client.start();
            }
        });
        
        Timer t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Data.data.equals(txtView.getText())) {
                    txtView.setText(Data.data);
                }
            }
        });
        t.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(pnlMain);
        pack();
        setSize(300,300);
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        ServerSocket server = new ServerSocket(3198);
//        Socket client = server.accept();
//        System.out.println("+1 connecting...");
//        DataOutputStream guiClient = new DataOutputStream(client.getOutputStream());
//        BufferedReader nhanClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        while(true){
//            String nhan = nhanClient.readLine();
//            System.out.println("C Send: " + nhan);
//            guiClient.writeBytes("Phan hoi tu server"+"\n");
//        }

         VServer sever = new VServer();
    }
    
}
