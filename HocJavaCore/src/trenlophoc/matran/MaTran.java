package trenlophoc.matran;
/**/
public class MaTran {
	private int n, m;
	private double M[][];
	public double[][] getMT(){
		return M;
	}
	public void setDong(int n) {
		this.n= n;
	}
	public void setCot(int m) {
		this.m = m;
	}
	public int getDong() {
		return n;
	}
	public int getCot() {
		return m;
	}
	public  MaTran(){} ;
	public  MaTran(int dong,int cot){
		this.n = dong;
		this.m = cot;
		M = new double[dong][cot];
	};
	public  MaTran(double M1[][]) {} ;
	
	public void inMaTran() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void nhapMaTran() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("MT["+i+"]["+j+"]= ");
				M[i][j] = Nhap.nhapInt();
			}
		}
	}
	public boolean kiemTraDoiXung() {
		boolean check = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(M[i][j] != M[j][i])
				{
					check = false;
					break;
				}
			}
		}
		return check;
	}
	public MaTran congMaTran(MaTran M1) {
		MaTran kq = new MaTran(M1.getCot(), M1.getDong());
		if(this.n != M1.getCot() || this.m != M1.getDong())
		{
			System.out.println("2 ma tran khong cong duoc.");
			return null;
		}
		for (int i = 0; i < M1.getCot(); i++) {
			for (int j = 0; j < M1.getDong(); j++) {
				kq.getMT()[i][j] = getMT()[i][j] + M1.getMT()[i][j];
			}
		}
		return kq;
	}
	public MaTran nhanMaTran (MaTran M2) {
		MaTran kq = new MaTran();
		return kq;
	}
	
	public static void main(String arg[]) {
		MaTran M1=new MaTran(2,2);
		MaTran M2 =new MaTran(2,2);
		M1.nhapMaTran();
		M1.inMaTran();
		if(M1.kiemTraDoiXung())
		{
			System.out.println("Doi xung.");
		}
		else {
			System.out.println("Khong doi dung.");
		}
		M2.nhapMaTran();
		M2.inMaTran();
		System.out.println("Cong");
		M1 = M1.congMaTran(M2);
		M1.inMaTran();
	}

}
