package baitapthuchanh.th3ncdagiac;
public class Run {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TamGiac tg = new TamGiac();
		tg.nhapCanh();
		tg.hienThiCanh();
		System.out.println();
		System.out.println("Chu vi = " + tg.tinhChuVi());
		System.out.println("Dien tich = " + tg.tinhDienTich());
	}

}
