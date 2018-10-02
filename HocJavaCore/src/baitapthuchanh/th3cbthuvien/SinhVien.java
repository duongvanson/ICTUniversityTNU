package baitapthuchanh.th3cbthuvien;

import java.util.Calendar;

public class SinhVien {
	String hoTen, lop;
	int namSinh;
	public void nhapSV() {
		int now = Calendar.getInstance().get(Calendar.YEAR);
		System.out.print("\tHo ten: ");
		hoTen = Nhap.nhapText();
		System.out.print("\tLop: ");
		lop = Nhap.nhapText();
		System.out.print("\tNam sinh: ");
		do {
			namSinh = Nhap.nhapInt();
			if(namSinh > now)
				System.out.print("\tNam sinh phai < "+now);
		}while(namSinh > now);
		
	}
	public void hienSV() {
		System.out.print(hoTen + "\t" + lop + "\t"+namSinh);
	}
}
