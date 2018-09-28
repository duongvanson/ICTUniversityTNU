package baitap.quanlysach;

import java.util.Scanner;
public class Sach {
	Scanner scn = new Scanner(System.in);
	private String tenSach;
	private String tenTacGia;
	private int namXuatBan;
	public Sach(String tenSach, String tenTacGia, int namXuatBan) {
		super();
		this.tenSach = tenSach;
		this.tenTacGia = tenTacGia;
		this.namXuatBan = namXuatBan;
	}
	public Sach() {}
	public void nhapSach() {
		System.out.print("\tTen sach: ");
		tenSach = scn.nextLine();
		System.out.print("\tTen tac gia: ");
		tenTacGia = scn.nextLine();		
		do {
			try {
				System.out.print("\tNam xuat ban: ");
				scn = new Scanner(System.in);
				namXuatBan = scn.nextInt();
				if(namXuatBan <= 0) {
					System.out.println("Nam xuat ban > 0");
				}
			} catch (Exception e) {
				namXuatBan = 0;
				System.out.println("Dau vao khong chinh xac.");
				// TODO: handle exception
			}
		}while(namXuatBan <= 0);
	}
	public void xuatSach() {
		System.out.println(tenSach + "\t" + tenTacGia + "\t"+namXuatBan);
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	
}
