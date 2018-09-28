import java.util.Scanner;

public class Nhap {
	static Scanner scn = new Scanner(System.in);
	public static double nhapDouble() {
		double number= 0.d;
		do {
			try {
				scn = new Scanner(System.in);
				number = scn.nextDouble();
			} catch (Exception e) {
				number = 0.d;
				System.out.println("Dau vao khong hop le.");
				// TODO: handle exception
			}
			
		}while(number <= 0.0);
		return number;
	}
}
