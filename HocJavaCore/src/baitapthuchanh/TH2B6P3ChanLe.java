package baitapthuchanh;

import java.util.Scanner;

public class TH2B6P3ChanLe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Nhap n= ");
		int n = scn.nextInt();
		int result = 0;
		if(n % 2 == 0) {
			for(int i = 1; i < n; i++)
				if(i % 2 == 0) result += i;
			System.out.print("Tong cac so chan < "+n+": "+result);
		}else {
			for(int i = 1; i < n; i++)
				if(i % 2 != 0) result += i;
			System.out.print("Tong cac so le < "+n+": "+result);
		}
	}

}
