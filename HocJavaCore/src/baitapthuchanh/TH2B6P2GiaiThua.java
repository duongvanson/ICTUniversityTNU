package baitapthuchanh;

import java.util.Scanner;

public class TH2B6P2GiaiThua {
	public static long giaiThua(int n) {
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Nhap n = ");
		int n = scn.nextInt();
		long result = 0;
		for(int i = 1; i <= n; i++) {
			result += giaiThua(i);
		}
		System.out.print("Tong GT: "+result+"\n");
	}

}
