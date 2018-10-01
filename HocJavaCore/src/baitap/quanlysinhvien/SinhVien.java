package baitap.quanlysinhvien;

import java.util.Scanner;

import baitapthuchanh.th3ncdagiac.Nhap;

public class SinhVien {
	//Scanner scn = new Scanner(System.in);
	private String maSV, hoTen;
	private int namSinh;
	private double diemToan, diemLy, diemHoa,diemTB;
	private double tinhTB() {
		return (diemToan*2.0 + diemLy + diemHoa)/4.0;
	}
	public void nhapTT() {
		System.out.print("\tMa SV: ");
		maSV = Nhap.nhapText();
		System.out.print("\tHo ten SV: ");
		hoTen = Nhap.nhapText();
		System.out.print("\tNam sinh: ");
		namSinh= Nhap.nhapInt();
		System.out.print("\tDiem toan: ");
		diemToan= Nhap.nhapDouble();
		System.out.print("\tDiem ly: ");
		diemLy= Nhap.nhapDouble();
		System.out.print("\tDiem hoa: ");
		diemHoa= Nhap.nhapDouble();
		diemTB= tinhTB();
	}
	public void inTT() {
		System.out.println(maSV + "\t" + hoTen + "\t" + namSinh + "\t"
				+ diemToan +"\t"+diemLy +"\t"+diemHoa+"\t"+diemTB);
	}
}
