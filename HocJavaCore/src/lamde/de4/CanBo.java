package lamde.de4;

public class CanBo extends NhanSu{
	private String maCanBo, chucVu;
	private double tongLuong;
	public void nhapDLCB() {
		super.nhapDLNS();
		System.out.println("Ma can bo: ");
		maCanBo = Nhap.nhapText();
		System.out.println("Chuc vu: ");
		chucVu = Nhap.nhapText();
		System.out.println("Tong luong: ");
		tongLuong = Nhap.nhapLuong();
		System.out.println("------------");
	}
	public double getTongLuong() {
		return tongLuong;
	}
	public void setTongLuong(double tongLuong) {
		this.tongLuong = tongLuong;
	}
	public void hienThiDLCB() {
		super.hienThiDLNS();
		System.out.println(maCanBo + "\t"+chucVu+"\t"+tongLuong+"\n");
	}
}
