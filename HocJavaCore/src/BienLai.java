import java.io.DataInputStream;
import java.io.IOException;

class KhachHang{
	private String hoTenChuHo;
	private int soNha;
	private String maSoCongTo;
	
	public String nhapXau()
	{
		DataInputStream str = new DataInputStream(System.in);
		String st;
		try {
			st = str.readLine();
		}catch(IOException io)
		{
			st = "";
		}
		return st;
	}
	public int doiInt(String st)
	{
		int so;
		try {
			so = Integer.parseInt(st);
		}catch(NumberFormatException ne)
		{
			so = 0;
		}
		return so;
	}
	public void nhapTT()
	{
		System.out.print("\tHo ten chu ho: ");
		hoTenChuHo = nhapXau();
		System.out.print("\tSo nha: ");
		soNha = doiInt(nhapXau());
		System.out.print("\tMa so cong to: ");
		maSoCongTo = nhapXau();
	}
	public void hienThiTT()
	{
		System.out.println("\tThong tin khach hang: "+hoTenChuHo+"     "+soNha+"     "+maSoCongTo);
	}
}
public class BienLai {
	private int soLuong;
	private int chiSoCu;
	private int chiSoMoi;
	private int soTienPhaiTra;
	private KhachHang kh = new KhachHang();
	private KhachHang khachHang;
	private BienLai[] bl;
	
	public void nhapThongTin()
	{
		khachHang = new KhachHang(); //Chua cap phat bo nho cho doi tuong khach hang
		khachHang.nhapTT();
		System.out.print("\tChi so cu: ");
		chiSoCu = kh.doiInt(kh.nhapXau());
		System.out.print("\tChi so moi: ");
		chiSoMoi = kh.doiInt(kh.nhapXau());
		System.out.print("\tSo tien phai tra: ");
		soTienPhaiTra = (chiSoMoi - chiSoCu) * 85000;
	}
	public void hienThiThongTin()
	{
		System.out.println("Thong tin bien lai: ");
		khachHang.hienThiTT();
		System.out.print("\tChi so cu: "+chiSoCu);
		System.out.print("\tChi so moi: "+chiSoMoi);
		System.out.print("\tSo tien phai tra: "+soTienPhaiTra);
	}
	public void nhapBienLai()
	{
		System.out.print("Nhap so luong bien lai: ");
		soLuong = kh.doiInt(kh.nhapXau());
		bl = new BienLai[soLuong];
		for(int i = 0; i < soLuong; i++)
		{
			System.out.println("Bien lai so "+(i+1)+": ");
			bl[i] = new BienLai();
			bl[i].nhapThongTin();
		}	
	}
	public void hienThiBienLai()
	{
		for(int i = 0; i < soLuong; i++)
		{
			System.out.println("Thong tin bien lai so "+(i+1)+": ");
			bl[i].hienThiThongTin();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BienLai bl = new BienLai();
		bl.nhapBienLai();
		bl.hienThiBienLai();
	}

}
