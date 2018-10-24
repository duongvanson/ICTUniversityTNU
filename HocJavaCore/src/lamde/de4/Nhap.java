package lamde.de4;

import java.util.Scanner;

public class Nhap {
	static Scanner scn;
	public static String nhapText() {
		String str = "";
		do {
			scn = new Scanner(System.in);
			str = scn.nextLine();
			str.trim();
			if (str.isEmpty()) {
				System.out.println("Khong duoc de trong! Nhap lai.\n");
			}
		} while (str.isEmpty());
		return str;
	}
	public static String nhapGT() {
		String str = "";
		do {
			scn = new Scanner(System.in);
			str = scn.nextLine();
			str.trim();
			if (!str.equalsIgnoreCase("NAM") && !str.equalsIgnoreCase("NU")) {
				System.out.println("Nhap lai.(nam\nu)\n");
			}
			if (str.isEmpty()) {
				System.out.println("Khong duoc de trong! Nhap lai.\n");
			}
		} while (!str.equalsIgnoreCase("NAM") && !str.equalsIgnoreCase("NU"));
		return str;
	}
	public static int nhapTuoi() {
		int tuoi= 0;
		do {
			try {
				scn = new Scanner(System.in);
				tuoi = scn.nextInt();
				if (tuoi < 0 || tuoi > 200) {
					System.out.println(" 0 < Tuoi < 200\n");
				}
			} catch (Exception e) {
				tuoi = -1;
				System.out.println("Dau vao khong hop le.");
				System.out.print("\tNhap lai: ");
				// TODO: handle exception
			}
		}while(tuoi < 0 || tuoi > 200 );
		return tuoi;
	}
	public static int nhapSL() {
		int tuoi= 0;
		do {
			try {
				scn = new Scanner(System.in);
				tuoi = scn.nextInt();
				if (tuoi < 0) {
					System.out.println(" So luong > 0");
				}
			} catch (Exception e) {
				tuoi = -1;
				System.out.println("Dau vao khong hop le.");
				System.out.print("\tNhap lai: ");
				// TODO: handle exception
			}
		}while(tuoi < 0);
		return tuoi;
	}
	public static double nhapLuong() {
		double number= 0.d;
		do {
			try {
				scn = new Scanner(System.in);
				number = scn.nextDouble();
				if(number < 0) {
					System.out.print("\tNhap lai: ");
				}
			} catch (Exception e) {
				number = -1.0;
				System.out.println("Dau vao khong hop le.");
				System.out.print("\tNhap lai: ");
				// TODO: handle exception
			}
			
		}while(number < 0.d);
		return number;
	}
}
