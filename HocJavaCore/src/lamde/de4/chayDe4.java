package lamde.de4;

public class chayDe4 {
	public static CanBo lstCanBo[];
	public static int soLuong;
	public static void nhapDL() {
		System.out.println("So luong: ");
		soLuong = Nhap.nhapSL();
		lstCanBo = new CanBo[soLuong];
		for (int i = 0; i < lstCanBo.length; i++) {
			lstCanBo[i] = new CanBo();
			lstCanBo[i].nhapDLCB();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nhapDL();
		System.out.println("=====\nNhap x: ");
		double x = Nhap.nhapLuong();
		for (int i = 0; i < lstCanBo.length; i++) {
			if (lstCanBo[i].getTongLuong() <= x) {
				lstCanBo[i].hienThiDLCB();
			}
		}
	}

}
