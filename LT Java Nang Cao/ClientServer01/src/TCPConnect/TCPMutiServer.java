package TCPConnect;

import java.awt.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ClientX extends Thread{
	Socket socket = null;
	BufferedReader fromClient;
	DataOutputStream toClient;
	public ClientX(Socket socket) throws Exception{
		// TODO Auto-generated constructor stub
		this.socket = socket;
		fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		toClient = new DataOutputStream(socket.getOutputStream());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String data = fromClient.readLine();
			toClient.writeBytes("LOL"+"\n");
			System.out.println(socket.getInetAddress()+": "+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class TCPMutiServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(3042);
		System.out.println(InetAddress.getByName("duongson-pc"));
		while(true) {
			Socket socket = server.accept();
			System.out.println("+1 ket noi "+socket.getInetAddress().toString());
			ClientX clientX = new ClientX(socket);
			clientX.start();
			Thread.sleep(2000);
			//socket.close();
		}
	}

}
