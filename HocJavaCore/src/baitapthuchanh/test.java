package baitapthuchanh;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scn;
		boolean check = true;
		do {
			System.out.print("n= ");
			try {
				scn = new Scanner(System.in);
				n= scn.nextInt();
				check = false;
				System.out.print("xxx");
			}
			catch(Exception e) {
				check = true;
			}
		}while(check);
	}

}
