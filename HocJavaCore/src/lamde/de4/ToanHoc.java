package lamde.de4;

import java.util.Scanner;

public class ToanHoc {
	public static int nhapDL() {
		Scanner scn = new Scanner(System.in);
		int number = 0;
		System.out.println("Nhap: ");
		do {
			try {
				number = scn.nextInt();
				if(number < 2 || number > 100)
					System.out.println("Nhap lai! (2<=number<=100)\n");
			} catch (Exception e) {
				System.out.println("Dau vao khong hop le!\n");
				number = 0;
			}
		} while (number<2 || number > 100);
		return number;
	}
	public static void inSCP(int number) {
		for (int i = 0; i <= number; i++) {
			int can = (int)Math.sqrt(i);
			if(i == (can*can))
				System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = nhapDL();
		inSCP(number);
	}

}
