package lamde.de3;

public class QLSinhVien {
	public static SinhVien sinhViens[];
	//
	public static int soLuong;
	public static void nhapDanhSach() {
		System.out.println("So luong: ");
		soLuong = Nhap.nhapSL();
		sinhViens = new SinhVien[soLuong];
		for(int i = 0; i < soLuong; i++) {
			System.out.println("Sinh vien " + (i+1));
			sinhViens[i] = new SinhVien();
			sinhViens[i].nhapTT();
		}
	}
	public static void hienThi() {
		for(int i = 0; i < soLuong; i++) {
			sinhViens[i].hienThiTT();
		}
	}
	public static void sapXep() {
		SinhVien temp = new SinhVien();
		for (int i = 0; i < sinhViens.length; i++) {
			for (int j = i+1; j < sinhViens.length; j++) {
				if(sinhViens[i].diemTB < sinhViens[j].diemTB) {
					temp = sinhViens[i];
					sinhViens[i] = sinhViens[j];
					sinhViens[j]= temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nhapDanhSach();
		hienThi();
		System.out.println("=====");
		sapXep();
		hienThi();
	}

}
