package trenlophoc.vanban;

import java.util.Scanner;
import java.lang.Character;
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
	public void upCase() {
		soucre = soucre.trim();
		StringBuffer sc = new StringBuffer(soucre);
		for (int i = 0; i < sc.length(); i++) {
			if(sc.charAt(i) == ' ' && sc.charAt(i+1) != ' ') {
				if(sc.charAt(i+1)>'a' && sc.charAt(i+1)<'z')
					sc.setCharAt(i+1,(char)((int)(sc.charAt(i+1))-32));
			}
		}
		if(sc.charAt(0)>'a' && sc.charAt(0)<'z')
			sc.setCharAt(0,(char)((int)(sc.charAt(0))-32));
		soucre = sc.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VanBan vb = new VanBan("   duong  van   son  ");
		
//		Scanner scn = new Scanner(System.in);
//		vb.setSoucre(scn.nextLine());
		
		vb.chuanHoa();
		String str = vb.getSoucre();
		if(!str.isEmpty()) {
			System.out.println(str);
			System.out.println(vb.demTu());
			System.out.println(vb.EndChar("G"));
			vb.upCase();
			System.out.println(vb.soucre);
		}else {
			System.out.println("Chuoi vao rong!");
		}
		
	}

}
