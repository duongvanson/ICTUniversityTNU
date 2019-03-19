package TCPConnect;
import java.io.*;
import java.net.*;
public class TCPServer {
	static boolean checkChuoiDoiXung(String str) {
		str = str.trim();
		int l = str.length();
		//System.out.println(l);
		for (int i = 0; i < l/2; i++) {
			if(str.charAt(i) != str.charAt(l-i-1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(3042);
		Socket connClient = server.accept();
		System.out.println("co 1 ket noi");
		String gui, nhan;
		DataOutputStream toClient = new DataOutputStream(connClient.getOutputStream());
		BufferedReader fromClient = new BufferedReader(new InputStreamReader(connClient.getInputStream()));
		while(true) {
			if(!connClient.isConnected()) {
				connClient.close();
				break;
			}
			nhan = fromClient.readLine();
			System.out.println("CLIENT: "+nhan);
			if(checkChuoiDoiXung(nhan)) {
				gui = "Chuoi doi xung";
			}else {
				gui = "Chuoi khong doi xung";
			}
			toClient.writeBytes(gui+'\n');
		}
	}

}
