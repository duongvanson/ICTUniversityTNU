package chattcp;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

class Mess{
    static StringBuilder Content = new StringBuilder();
}
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
            while(true){
                try {
			String data = fromClient.readLine();
                        if(!data.equals("")) Mess.Content.append(data+"%");
			toClient.writeBytes(Mess.Content+"\n");
                        System.out.println("Mess: " + Mess.Content);
			System.out.println(socket.getInetAddress()+": "+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
		// TODO Auto-generated method stub
	}
}
public class ServerTCP {
    public static void main(String[] args) throws IOException, Exception {
        Scanner scn = new Scanner(System.in);
        ServerSocket server = new ServerSocket(3198);
//        Socket s1 = server.accept();
//        System.out.println("+1 ket noi");
//        String gui, nhan;
//        DataOutputStream guiClient = new DataOutputStream(s1.getOutputStream());
//        BufferedReader nhanClient = new BufferedReader(new InputStreamReader(s1.getInputStream()));
        while (true) {            
            Socket socket = server.accept();
                System.out.println("+1 ket noi "+socket.getInetAddress().toString());
                ClientX clientX = new ClientX(socket);
                clientX.start();
               // Thread.sleep(2000);
//            nhan = nhanClient.readLine();
//            System.out.println("Client: "+nhan);
//            System.out.print("Send Client: ");
//            String send = scn.nextLine();
//            guiClient.writeBytes("OK"+'\n');
        }
    }
}
