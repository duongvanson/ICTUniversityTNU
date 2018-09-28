package baitap.quanlysach;

import java.util.Scanner;
import java.util.Random;
public class QuanLySach {
	public static void nhapSachs(Sach[] sachs, int n) {
		for (int i = 0; i < sachs.length; i++) {
			System.out.println("Sach["+(i+1)+"]: ");
			sachs[i] = new Sach();
			sachs[i].nhapSach();
		}
	}
	public static void xuatSachs(Sach[] sachs, int n) {
		System.out.println("SACH TRONG KHO");
		for (int i = 0; i < sachs.length; i++) {
			sachs[i].xuatSach();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int soLuong = 0;
		do {
			try {
				scn = new Scanner(System.in);
				System.out.print("So luong sach: ");
				soLuong = scn.nextInt();
				if (soLuong <= 0) {
					System.out.println("404! So luong phai > 0");
				}
			} catch (Exception e) {
				System.out.println("Dau vao khong hop le.");
				soLuong = 0;
				// TODO: handle exception
			}
		} while (soLuong <= 0);
		Sach[] sachs = new Sach[soLuong];
		//Auto nhap
		int n = soLuong, i = 0;
		Random rd = new Random();
		while(n > 0) {
			String tenSach =
					""+(char)(65+rd.nextInt(26))
					+(char)(65+rd.nextInt(26))
					+(char)(65+rd.nextInt(26))
					+(char)(65+rd.nextInt(26))+"";
			String tacGia = 
					""+((char)(97+rd.nextInt(26)))
					+((char)(97+rd.nextInt(26)))
					+((char)(97+rd.nextInt(26)))
					+((char)(97+rd.nextInt(26)))+"";
			int namXuatBan = 1990+rd.nextInt(28);
			sachs[i] = new Sach(tenSach, tacGia, namXuatBan);
			n--;i++;
		}
		//QuanLySach.nhapSachs(sachs, soLuong);
		xuatSachs(sachs, soLuong);
	}

}
