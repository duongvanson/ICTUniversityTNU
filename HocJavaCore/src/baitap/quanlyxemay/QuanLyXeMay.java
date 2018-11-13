package baitap.quanlyxemay;

import java.util.ArrayList;

public class QuanLyXeMay {
	static ArrayList<XeMay> lstXe = new ArrayList<>();
	static int soLuong = 0;
	public static void nhapDSXe() {
		XeMay xe;
		System.out.print("So luong: ");
		soLuong = Nhap.nhapSL();
		for (int i = 0; i < soLuong; i++) {
			System.out.println("[Nhap xe " + (i +1)+"]");
			xe = new XeMay();
			xe.nhapXe();
			lstXe.add(xe);
		}
	}
	public static void xeTheoNamSX() {
		int x, count = 0;
		XeMay xe;
		System.out.print("Nhap nam sx: ");
		x = Nhap.nhapNam();
		for (int i = 0; i < soLuong; i++) {
			xe = lstXe.get(i);
			if (xe.getNamSX() <= x) {
				count++;
			}
		}
		System.out.println("Co " + count + " san xuat <= " + x);
	}
	public static void xeTheoHang(String hang) {
		XeMay xe;
		for (int i = 0; i < soLuong; i++) {
			xe = lstXe.get(i);
			if (xe.getHangSX().toLowerCase().equals(hang.toLowerCase())) {
				xe.hienXe();
			}
		}
	}
	public static void main(String[] args) {
		nhapDSXe();
		System.out.println("========");
		xeTheoNamSX();
		System.out.println("========");
		xeTheoHang("Yamaha");
	}
}
