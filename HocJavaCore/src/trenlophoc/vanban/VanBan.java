package trenlophoc.vanban;

import java.util.Scanner;

public class VanBan {
	private String soucre;
	public VanBan() {}
	public VanBan(String str) {
		soucre = str;
	}
	public String getSoucre() {
		return soucre;
	}
	public void setSoucre(String str) {
		soucre = str;
	}
	public int demTu() {
		if(soucre.isEmpty()) return 0;
		chuanHoa();
		int dem = 0;
		for (int i = 0; i < soucre.length(); i++) {
			if(soucre.charAt(i) == ' ')
				dem++;
		}
		return dem + 1;
	}
	public int EndChar(String ch) {
		if(soucre.isEmpty()) return 0;
		int dem = 0;
		String str[] = soucre.split(" ");
		for (int i = 0; i < str.length; i++) {
			if(str[i].endsWith(ch.toLowerCase())
			|| str[i].endsWith(ch.toUpperCase()))
				dem++;
		}
		return dem;
	}
	public void chuanHoa() {
		soucre = soucre.trim();
		StringBuffer sc = new StringBuffer(soucre);
		for (int i = 0; i < sc.length(); i++) {
			if(sc.charAt(i) == ' ' && sc.charAt(i+1) == ' ') {
				sc.deleteCharAt(i);
				i--;
			}
		}
		soucre = sc.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VanBan vb = new VanBan("   DUONG   VAN   SON  ");
		
//		Scanner scn = new Scanner(System.in);
//		vb.setSoucre(scn.nextLine());
		
		vb.chuanHoa();
		String str = vb.getSoucre();
		if(!str.isEmpty()) {
			System.out.println(str);
			System.out.println(vb.demTu());
			System.out.println(vb.EndChar("G"));
		}else {
			System.out.println("Chuoi vao rong!");
		}
		
	}

}
