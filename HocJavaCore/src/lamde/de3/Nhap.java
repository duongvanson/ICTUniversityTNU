package lamde.de3;

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
		public static int nhapInt() {
			int number= 0;
			boolean check = true;
			do {
				try {
					scn = new Scanner(System.in);
					
					number = scn.nextInt();
					check = true;
				} catch (Exception e) {
					check = false;
					System.out.println("Dau vao khong hop le.");
					System.out.print("\tNhap lai: ");
					// TODO: handle exception
				}
			}while(check == false);
			return number;
		}
		public static int nhapSL() {
			int number= 0;
			do {
				try {
					scn = new Scanner(System.in);
					number = scn.nextInt();
					if(number < 0)
						System.out.println("So luong > 0\nNhap lai");
				} catch (Exception e) {
					number = -1;
					System.out.println("Dau vao khong hop le.");
					System.out.print("\tNhap lai: ");
					// TODO: handle exception
				}
			}while(number < 0);
			return number;
		}
		public static int nhapMau() {
			int number= 0;
			do {
				try {
					scn = new Scanner(System.in);
					number = scn.nextInt();
					if(number == 0) {
						System.out.print("\tMau so != 0.\nNhap lai");
					}
				} catch (Exception e) {
					number = 0;
					System.out.println("Dau vao khong hop le.");
					System.out.print("\tNhap lai: ");
					// TODO: handle exception
				}
				
			}while(number == 0);
			return number;
		}
		public static double nhapDouble() {
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
