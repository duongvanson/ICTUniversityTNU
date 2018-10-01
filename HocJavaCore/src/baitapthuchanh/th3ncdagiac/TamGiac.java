package baitapthuchanh.th3ncdagiac;
public class TamGiac extends DaGiac{
	public void nhapCanh() {
		canhs = new double[3];
		for(int i = 0; i < 3; i++) {
			System.out.print("Cach ["+(i+1)+"]= ");
			canhs[i] = Nhap.nhapDouble();
		}
	}
	public double tinhChuVi() {
		double chuVi = 0.d;
		for(int i = 0; i < canhs.length; i++) {
			chuVi += canhs[i];
		}
		return chuVi;
	}
	public void hienThiCanh() {
		System.out.print("Danh sach cac canh tam giac: ");
		for(int i = 0; i < canhs.length; i++) {
			System.out.print(canhs[i] + " ");
		}
	}
	public double tinhDienTich() {
		double p = tinhChuVi()/2.0;
		return Math.sqrt(p*(p-canhs[0])*(p-canhs[0])*(p-canhs[2]));
	}
}
