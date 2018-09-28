package baitapthuchanh;
import java.util.Scanner;
public class TH2B4TimNguyenTo {
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
			int n = 0;
			do {
				System.out.print("\nNhap n: ");
				try {
					scn = new Scanner(System.in);
					n = scn.nextInt();
					if(n < 0)
					{
						System.out.print("Dau vao khong hop le.\n");
						n = 0;
						continue;
					}
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
					while(c < n) {
						if(kiemTraSNT(c))
							System.out.print(c + " ");
						c++;
					}
					System.out.println("");
					System.out.print("Dung do while: ");
					int d = 1;
					do {
						if(kiemTraSNT(d))
							System.out.print(d + " ");
						d++;
					}while(d < n);
				}catch(Exception e) {
					//System.out.print(e.getMessage());
					System.out.print("Dau vao khong hop le.");
					n = 0;
				}
			}while(n >= 0);
		}
}
