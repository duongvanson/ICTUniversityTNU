package baitapthuchanh.th3cbthuvien;
import java.util.Calendar;
import java.util.Scanner;

public class Nhap {
	static Scanner scn = new Scanner(System.in);
	public static String nhapText() {
		String text = "";
		do {
			scn = new Scanner(System.in);
			text = scn.nextLine();
			text = text.trim();
			if (text.isEmpty()) {
				System.out.println("Khong duoc de trong.");
				System.out.print("\tNhap lai: ");
			}
		} while (text.isEmpty());
		return text;
	}
	public static double nhapDouble() {
		double number= 0.d;
		do {
			try {
				scn = new Scanner(System.in);
				number = scn.nextDouble();
				if(number <= 0.0) {
					System.out.println("Canh >= 0");
					System.out.print("\tNhap lai: ");
				}
			} catch (Exception e) {
				number = 0.d;
				System.out.println("Dau vao khong hop le.");
				System.out.print("\tNhap lai: ");
				// TODO: handle exception
			}
			
		}while(number <= 0.d);
		return number;
	}
	public static int nhapInt() {
		int number= 0;
		do {
			try {
				scn = new Scanner(System.in);
				number = scn.nextInt();
				if(number <= 0) {
					System.out.print("\tNhap lai: ");
				}
			} catch (Exception e) {
				number = 0;
				System.out.println("Dau vao khong hop le.");
				System.out.print("\tNhap lai: ");
				// TODO: handle exception
			}
			
		}while(number <= 0);
		return number;
	}
}
