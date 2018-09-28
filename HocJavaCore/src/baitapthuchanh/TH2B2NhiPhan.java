package baitapthuchanh;

import java.util.Scanner;

public class TH2B2NhiPhan {
	public static String nhiPhan(int n) {
		if(n == 0) return "0";
		String result = "";
		while(n != 0) {
			result += n%2;
			n /= 2;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n;
		do {
			System.out.print("\nNhap n= ");
			try {
				scn = new Scanner(System.in);
				n = scn.nextInt();
				if(n < 0) {
					System.out.println("Dau vao phai >= 0.");
				}else {
					System.out.print("Result: ");
					String res = nhiPhan(n);
					for (int i = res.length()-1; i >= 0;i--) {
						System.out.print(res.charAt(i));
					}
				}
			}catch(Exception e) {
				System.out.print("Dau vao sai.\n");
				n = 0;
				continue;
			}
			if(n == -1) {
				System.out.print("Close program!");
				break;
			}
		}while(n != -1);
	}

}
