package lamde.de4;
public class NhanSu {
	public String hoTen, gioiTinh, queQuan;
	public int tuoi;
	public NhanSu(String hoTen, String gioiTinh, String queQuan, int tuoi) {
		super();
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.queQuan = queQuan;
		this.tuoi = tuoi;
	}
	public NhanSu() {
		
	}
	public void nhapDLNS() {
		System.out.println("Ho ten: ");
		hoTen = Nhap.nhapText();
		System.out.println("Tuoi: ");
		tuoi = Nhap.nhapTuoi();
		System.out.println("Gioi tinh: ");
		gioiTinh = Nhap.nhapGT();
		System.out.println("Que quan: ");
		queQuan = Nhap.nhapText();
	}
	public void hienThiDLNS() {
		System.out.println(hoTen + "\t" + tuoi +"\t"+gioiTinh + "\t"+queQuan+"\t");
	}
}
