package lamde.de3;
public class PhanSo {
	public int tuSo;
	public int mauSo;
	
	public void nhapDL() {
		System.out.println("Tu so: ");
		tuSo = Nhap.nhapInt();
		System.out.println("Mau so: ");
		mauSo = Nhap.nhapMau();
	}
	public void xemDL() {
		System.out.println("PS: " + tuSo + "/" + mauSo+"\n");
	}
	private int timUoc(int num1, int num2) {
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		while(num1 != num2) {
			if(num1 > num2)
				num1 -= num2;
			else num2 -= num1;
		}
		return num1;
	}
	public void toiGian() {
		int u = timUoc(tuSo, mauSo);
		tuSo /= u;
		mauSo /= u;
	}
	
}
