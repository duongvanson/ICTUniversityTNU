/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpjava;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author dvson
 */
public class VClient {
    public static Socket client;
    public static BufferedReader nhanServer;
    public static DataOutputStream guiServer;
    public static void main(String[] args) throws UnknownHostException, IOException {
        client = new Socket(InetAddress.getLocalHost().getHostName(), 3198);
        nhanServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        guiServer = new DataOutputStream(client.getOutputStream());
        
        //System.out.println(InetAddress.getLocalHost().getHostName());
        
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.print("Gui server: ");
            String gui = scn.nextLine();
            guiServer.writeBytes(gui+"\n");
            String nhan = nhanServer.readLine();
            System.out.println("S Gui: " + nhan);
        }
    }
}
