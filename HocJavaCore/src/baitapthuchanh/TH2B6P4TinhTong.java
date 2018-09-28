package baitapthuchanh;

import java.util.Scanner;

public class TH2B6P4TinhTong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhap n= ");
			n = scn.nextInt();
			if(n == -1) {
				System.out.print("Close program!");
				break;
			}
			double result = 0.0;
			for (int i = 1; i < n; i++) {
				result += ((double)i/(i+1));
			}
			System.out.print("Tong: "+result+"\n");
		}while(n != -1);
	}

}
