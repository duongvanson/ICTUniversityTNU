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
public class SClient extends JFrame{
    Socket client;
    DataOutputStream guiServer;
    BufferedReader nhanServer;
    public SClient(){
        try {
            client = new Socket(InetAddress.getLocalHost().getHostName(), 3198);
            guiServer = new DataOutputStream(client.getOutputStream());
            nhanServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        JLabel lblDai = new JLabel("Chieu dai: "),
               lblRong = new JLabel("Chieu rong: "),
               lblResult = new JLabel("...");
        JTextField txtDai = new JTextField(),
                   txtRong = new JTextField();
        JButton btnTinh = new JButton("Gui server");
        
        lblDai.setBounds(20,50,100,30);
        txtDai.setBounds(20,80,200,30);
        lblRong.setBounds(20,110,100,30);
        txtRong.setBounds(20,140,200,30);
        btnTinh.setBounds(20,190,100,30);
        lblResult.setBounds(20, 220, 200, 30);
        
        getContentPane().add(lblDai);
        getContentPane().add(txtDai);
        getContentPane().add(lblRong);
        getContentPane().add(txtRong);
        getContentPane().add(btnTinh);
        getContentPane().add(lblResult);
        this.setLayout(new BorderLayout());
        
        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String gui = txtDai.getText() + " " + txtRong.getText();
                    guiServer.writeBytes(gui+"\n");
                    String nhan = nhanServer.readLine();
                    lblResult.setText(nhan);
                    txtDai.setText("");
                    txtRong.setText("");
                } catch (IOException ex) {
                    Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(300,300);
    }
    public static void main(String[] args) {
        new SClient();
    }
}
