package lamde.de3;

public class SinhVien {
	public String hoTen, lop;
	public int namSinh;
	public double diemTB;
	public SinhVien() {}
	public SinhVien(String hoTen, int namSinh, String lop, double diemTB) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.lop = lop;
		this.diemTB = diemTB;
	}
	
	public void nhapTT() {
		System.out.println("Ho ten: ");
		this.hoTen = Nhap.nhapText();
		System.out.println("Nam sinh: ");
		this.namSinh = Nhap.nhapInt();
		System.out.println("Lop: ");
		this.lop = Nhap.nhapText();
		System.out.println("Diem TB: ");
		this.diemTB = Nhap.nhapDouble();
	}
	public void hienThiTT() {
		System.out.println(this.hoTen
				+ "\t" + this.namSinh
				+ "\t" + this.lop
				+ "\t" + this.diemTB + "\n");
	}
}
