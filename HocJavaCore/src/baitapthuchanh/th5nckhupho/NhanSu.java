package baitapthuchanh.th5nckhupho;

import java.util.Calendar;

import baitapthuchanh.th3cbthuvien.Nhap;

public class NhanSu{
	String hoTen, ngheNghiep;
	int namSinh, soNha;
	
	public void nhapNS(boolean b) {
		int now = Calendar.getInstance().get(Calendar.YEAR);
		System.out.print(" Ho ten: ");
		hoTen = Nhap.nhapText();
		System.out.print(" Nghe nghiep: ");
		ngheNghiep = Nhap.nhapText();
		System.out.print(" Nam sinh: ");
		do {
			namSinh = Nhap.nhapInt();
			if(namSinh > now)
				System.out.print("\tNam sinh phai < "+now);
		}while(namSinh > now);
		if(b) {
			System.out.print(" So nha: ");
			soNha = Nhap.nhapInt();
		}
	}
	
	public void xemNS() {
		System.out.println(hoTen + "\t" + ngheNghiep + "\t" + namSinh + "\t" + soNha);
	}
}
