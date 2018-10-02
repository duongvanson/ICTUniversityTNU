package baitapthuchanh.th3cbthuvien;

public class TheMuon extends SinhVien {
	int soPhieu;
	String ngayMuon, hanTra, soHieuSach;
	public void nhapThe() {
		System.out.print("\tSo phieu: ");
		soPhieu = Nhap.nhapInt();
		System.out.print("\tNgay muon (ngay/thang/nam): ");
		ngayMuon = Nhap.nhapText();
		System.out.print("\tHan tra (ngay/thang/nam): ");
		hanTra = Nhap.nhapText();
		System.out.print("\tSo hieu sach: ");
		soHieuSach = Nhap.nhapText();
		System.out.println("Thong tin sinh vien.");
		super.nhapSV();
	}
	public void xemThe() {
		System.out.print(soPhieu + "\t" + ngayMuon + "\t" + hanTra + "\t" + soHieuSach+ "\t");
		super.hienSV();
	}
}
