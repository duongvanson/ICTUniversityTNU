package baitapthuchanh;

import java.util.Scanner;

public class TH2B5ToanHoc {
	//Ham kiem tra so nguyen to
	public static boolean ktSoNguyenTo(int n) {
		if(n < 2) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		for(int i = 2; i <= n/2; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	//Ham kiem tra so hoan hao
	public static boolean ktSoHoanHao(int n) {
		int uc = 0;
		for(int i = 1; i < n; i++) {
			if(n % i == 0) uc += i;
		}
		return (uc == n);
	}
	//Ham in cac so chinh phuong < n
	public static void inSoChinhPhuong(int n) {
		for(int i = 1; i <= n; i++) {
			int temp = (int)Math.sqrt(i);
			if (temp*temp == i) {
				System.out.print(i + " ");
			}
		}
		System.out.print("\n");
	}
	//Ham tinh so fibonaci thu n
	public static long tinhFibo(int n) {
		long a =1, b=1, c = 0;
		if(n <= 2) return 1;
		n = n - 2;
		while(n > 0) {
			c = a + b;
			a = b;
			b = c;
			n--;
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhap n = ");
			try {
				scn = new Scanner(System.in);
				n = scn.nextInt();
			}catch(Exception e) {
				System.out.print("Dau vao sai.\n");
				n = 0;
				continue;
			}
			if(n == -1) {
				System.out.print("Close program!");
				break;
			}
			if(ktSoNguyenTo(n))
				System.out.print("\t"+n + " la so nguyen to.\n");
			else System.out.print("\t"+n + " khong la so nguyen to.\n");
			if(ktSoHoanHao(n))
				System.out.print("\t"+n + " la so hoan hao.\n");
			else System.out.print("\t"+n + " khong la so hoan hao.\n");
			System.out.print("\tDanh sach so chinh phuong < " + n + ": ");
			inSoChinhPhuong(n);
			if(n > 0) {
				System.out.print("\tPhan tu fibonaci thu "+n+": " + tinhFibo(n)+"\n");
			}
		}while(n != -1);
		
	}
}
