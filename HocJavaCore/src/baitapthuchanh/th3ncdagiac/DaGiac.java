package baitapthuchanh.th3ncdagiac;
public class DaGiac {
	int soCanh;
	double canhs[];
	public void nhapCanh(){
		System.out.print("So luong canh: ");
		soCanh = Nhap.nhapInt();
		canhs = new double[soCanh];
		for(int i = 0; i < soCanh; i++) {
			canhs[i] = Nhap.nhapDouble();
		}
	}
	public double tinhChuVi() {
		double chuVi = 0.d;
		for(int i = 0; i < soCanh; i++) {
			chuVi += canhs[i];
		}
		return chuVi;
	}
	public void hienThiCanh() {
		System.out.print("Danh sach cac canh: ");
		for(int i = 0; i < soCanh; i++) {
			System.out.print(canhs[i] + " ");
		}
	}
}
