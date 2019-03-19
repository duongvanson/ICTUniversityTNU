package TCPConnect;
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class TCPClient {
	
	public static Socket clientSocket;
	private BufferedReader fromServer;
	private DataOutputStream toServer;
	
	public TCPClient() throws Exception{
		//Socket clientSocket = new Socket("duongson-pc",3042);
		Socket clientSocket = new Socket("TUyenOC",69);
		fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		toServer = new DataOutputStream(clientSocket.getOutputStream());
	}
	public String sendServer(String mess) throws Exception{
		toServer.writeBytes(mess+"\n");
		return fromServer.readLine();
	}
	public static void main(String[] args) throws Exception {
//		new TCPClient();
//		//Scanner scn = new Scanner(System.in);
//		// TODO Auto-generated method stub
//		String gui, nhan;
//		BufferedReader fromUser = new BufferedReader(
//				new InputStreamReader(System.in));
//		BufferedReader fromServer = new BufferedReader(
//				new InputStreamReader(clientSocket.getInputStream()));
//		DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
//		while(true) {
//			System.out.println("Chuoi kiem tra: ");
//			gui = fromUser.readLine();
//			toServer.writeBytes(gui+'\n');
//			//Nhan du lieu tra ve tu server
//			nhan = fromServer.readLine()+"\n";
//			System.out.println("SERVER: "+nhan);
//		}
	}

}
