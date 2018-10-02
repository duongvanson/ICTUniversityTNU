package baitapthuchanh.th5nckhupho;
public class HoDan {
	int soThanhVien, soNha;
	private NhanSu nhanSus[];
	
	public void nhapHoDan() {
		System.out.print(" So thanh vien: ");
		soThanhVien = Nhap.nhapInt();
		System.out.print(" So nha: ");
		soNha = Nhap.nhapInt();
		System.out.println(" Thong tin cac thanh vien");
		nhanSus = new NhanSu[soThanhVien];
		for(int i = 0; i < soThanhVien; i++) {
			nhanSus[i] = new NhanSu();
			System.out.println(" *Thanh vien ["+(i+1)+"+]");
			nhanSus[i].nhapNS(false);
			nhanSus[i].soNha = soNha;
		}
	}
	
	public void xemHoDan() {
		System.out.print(soNha + "\t" + soThanhVien + "\n");
		System.out.println(" Thong tin cac thanh vien.");
		for(int i = 0; i < soThanhVien; i++) {
			nhanSus[i].xemNS();
		}
	}
}
