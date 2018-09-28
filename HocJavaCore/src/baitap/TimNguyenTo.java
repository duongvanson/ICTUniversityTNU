//Bai tap 4 BTH 2
package baitap;
import java.util.Scanner;
public class TimNguyenTo {
	public static boolean kiemTraSNT(int x) {
		if(x < 2) return false;
		if(x == 2) return true;
		if(x % 2 == 0) return false;
		for(int i = 2; i <= x/2; i++) {
			if(x % i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = scn.nextInt();
		System.out.println("DANH SACH SO NGUYEN SO < "+n);
		//Dung for
		System.out.print("Dung for: ");
		for(int i = 1; i < n; i++) {
			if(kiemTraSNT(i) == true)
				System.out.print(i + " ");
		}
		System.out.println("");
		System.out.print("Dung while: ");
		int c = 1;
		while(c <= n) {
			if(kiemTraSNT(c))
				System.out.print(c + " ");
			c++;
		}
		System.out.println("");
		System.out.print("Dung so while: ");
		int d = 2;
		do {
			if(kiemTraSNT(d))
				System.out.print(d + " ");
			d++;
		}while(d <= n);
		
	}
}
