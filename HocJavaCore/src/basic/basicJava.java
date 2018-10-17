package basic;

import java.util.Scanner;

public class basicJava {
	public static void nhap(int a[], int n) {
		Scanner scn = new Scanner(System.in);
		for(int j = 0; j < n; j++) {
			System.out.print("Nhap pt: ");
			a[j] = scn.nextInt();
		}
	}
	public static void xuat(int a[], int n) {
		for(int j = 0; j < n; j++) {
			System.out.print(a[j]+ " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		float f;
		double d;
		long l;
		String str;
		char c;
		
		int[] arr;
		int[] arr2 = new int[10];
		int arr3[] = new int[10];
		int arr4[];
		int[][] haich;
		int[][] haich2 = new int[2][2];
		
		System.out.println("\t \n \r");
		Scanner scn = new Scanner(System.in);
		int sl;
		sl = scn.nextInt();
		nhap(arr2, sl);
		xuat(arr2, sl);
//		
//		int hang, cot;
//		System.out.print("Nhap hang: ");
//		hang = scn.nextInt();
//		System.out.print("Nhap cot: ");
//		cot = scn.nextInt();
//		haich = new int[hang][cot];
//		for(int j = 0; j < hang; j++) {
//			for(int k = 0; k < cot; k++) {
//				System.out.print("Nhap pt: " + (j+1) + "," + (k+1) +"= ");
//				haich[j][k] = scn.nextInt();
//			}
//		}
//		for(int j = 0; j < hang; j++) {
//			for(int k = 0; k < cot; k++) {
//				System.out.print(haich[j][k]+" ");
//			}
//			System.out.println();
//		}
		//--0 1 2 3 4 5
		// 1 2 4
		// 3 5 6
		// 8 7 3
//		int sl;
//		sl = scn.nextInt();
//		arr = new int[sl];
//		
//		for(int j = 0; j < sl; j++) {
//			System.out.print("Nhap pt: ");
//			arr[j] = scn.nextInt();
//		}
////		arr[0] = 45;
////		arr[5] = 100;
//		for(int j = 0; j < sl; j++) {
//			System.out.print(arr[j] + " ");
//		}
		
//		System.out.print("Nhap i: ");
//		try {
//			i = scn.nextInt();
//			System.out.println("gia tri: " + i);
//		} catch (Exception e) {
//			System.out.println("Dau vao khong dung.");
//		}
		//f = scn.nextFloat();
//		str = scn.nextLine();
//		System.out.println("chuoi: " + str);
		
	}

}
