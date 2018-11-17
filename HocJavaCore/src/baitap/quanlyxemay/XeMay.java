package baitap.quanlyxemay;
public class XeMay {
	private String tenXe, hangSX;
	private int soMay, soKhung,  namSX;
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getHangSX() {
		return hangSX;
	}
	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}
	public int getSoMay() {
		return soMay;
	}
	public void setSoMay(int soMay) {
		this.soMay = soMay;
	}
	public int getSoKhung() {
		return soKhung;
	}
	public void setSoKhung(int soKhung) {
		this.soKhung = soKhung;
	}
	public int getNamSX() {
		return namSX;
	}
	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}
	public XeMay(String tenXe, String hangSX, int soMay, int soKhung, int namSX) {
		super();
		this.tenXe = tenXe;
		this.hangSX = hangSX;
		this.soMay = soMay;
		this.soKhung = soKhung;
		this.namSX = namSX;
	}
	public XeMay() {
		
	}
	public XeMay(String tenXe) {
		this.tenXe = tenXe;
	}
	public void nhapXe() {
		System.out.print("Ten xe: ");
		tenXe = Nhap.nhapText();
		System.out.print("Hang SX: ");
		hangSX = Nhap.nhapText();
		System.out.print("So may: ");
		soMay = Nhap.nhapInt();
		System.out.print("So khung: ");
		soKhung = Nhap.nhapInt();
		System.out.print("Nam sx: ");
		namSX = Nhap.nhapNam();
	}
	public void hienXe() {
		System.out.println(
				  tenXe + "\t"
				+ hangSX + "\t"
				+ soMay + "\t"
				+ soKhung + "\t"
				+ namSX);
	}
}
