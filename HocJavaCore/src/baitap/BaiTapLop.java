package baitap;
import java.util.Scanner;
public class BaiTapLop {
	public static boolean kiemTraSNT(int so) {
		if(so < 2) return false;
		if(so == 2) return true;
		if(so % 2 == 0) return false;
		for(int i = 2; i < so/2; i++) {
			if(so % i == 0)
				return false;
		}
		return true;
	}
	public static boolean kiemTraSHH(int so) {
		int tong = 0;
		for(int i = 1; i < so; i++)
			if(so % i == 0)
				tong += i;
		return (tong == so);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// TODO Auto-generated method stub
		int m = 0;
		System.out.print("So phan tu: ");
		do {
			m = scn.nextInt();
			if(m <= 2 || m >= 100)
				System.out.print("Nhap lai: ");
		}while(m <= 2 || m >= 100);
		
		int mang[] = new int[m];
		//Nhap mang
		for(int i = 0; i < m; i++) {
			System.out.print("Nhap pt " + (i+1)+"= ");
			mang[i] = scn.nextInt();
		}
		//In cac so nguyen to
		System.out.print("Danh sach SNT: ");
		for(int i = 0; i < m; i++) {
			if(kiemTraSNT(mang[i]))
				System.out.print(mang[i]+" ");
		}
		System.out.println();
		//Trung binh cong cua cac so hoan hao
		double tong = 0.0;
		int dem = 0;
		for(int i = 0; i < m; i++) {
			if(kiemTraSHH(mang[i]))
			{
				dem++;
				tong += mang[i];
			}
		}
		System.out.println("TB cong cac SHH: " + (tong/dem));
		//Hien thi phan tu nho nhat
		int min = mang[0];
		for(int i = 1; i < m; i++) {
			if(min > mang[i])
				min = mang[i];
		}
		System.out.println("So nho nhat: " + min);
	}

}
