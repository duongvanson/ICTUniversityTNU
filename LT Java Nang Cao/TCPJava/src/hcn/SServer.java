package hcn;
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
            BufferedReader nhanTuClient = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            DataOutputStream guiToiClient = new DataOutputStream(
            client.getOutputStream());
            
            while(true){
                String nhan = nhanTuClient.readLine();
                Data.data += "(" + nhan + ")\n";
                System.out.println(nhan);
                String [] arr = nhan.split(" ");
                double dai = Double.parseDouble(arr[0]);
                double rong = Double.parseDouble(arr[1]);
                guiToiClient.writeBytes("Dien tich: " + (dai*rong) + "\n");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ClientX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
public class SServer extends JFrame{
    public SServer(){
        JPanel pnlMain = new JPanel(new BorderLayout()),
               pnlBot = new JPanel(new BorderLayout());
        JTextArea txtView = new JTextArea();
        txtView.enable(false);
        JButton btnChay = new JButton("Khoi dong");
        JLabel lblStatus = new JLabel("...");
        
        pnlBot.add(btnChay, BorderLayout.WEST);
        pnlBot.add(lblStatus, BorderLayout.EAST);
        
        pnlMain.add(txtView, BorderLayout.CENTER);
        pnlMain.add(pnlBot, BorderLayout.PAGE_END);
        
        btnChay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblStatus.setText("Đã khởi động server.");
                ClientX cx = new ClientX();
                cx.start();
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
        getContentPane().add(pnlMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setSize(400,400);
    }
    public static void main(String[] args) {
        new SServer();
    }
}
