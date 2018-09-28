package baitapthuchanh;
import java.util.Scanner;
public class TH2B3NgayThangNam {
		public static int[] arrThang = {31,28,31,30,31,30,31,31,30,31,30,31};
		public static boolean kiemTraNgayThang(int thang, int ngay,int nam) {
			if(nam % 100 == 0 && nam % 4 ==0)
			{
				arrThang[1] = 29;
			}
			return (ngay <= arrThang[thang - 1]);
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int ngay, thang, nam;
			String noti = "Đầu vào sai";
			Scanner scn = new Scanner(System.in);
			//Nam
			do {
				try {
					scn = new Scanner(System.in);
					System.out.print("Nam: ");
					nam = scn.nextInt();
				}catch(Exception e) {
					nam = 0;
					System.out.print(noti);
						}
			}while(nam <= 0);
			//Ngay
			do {
				System.out.print("Ngay: ");
				try {
					scn = new Scanner(System.in);
					ngay = scn.nextInt();
				}
				catch(Exception e){
					ngay = 0;
					System.out.print(noti);
				}
				
			}while(ngay<=0 || ngay >31);
			//Thang
			do {
				System.out.print("Thang: ");
				try {
					scn = new Scanner(System.in);
					thang = scn.nextInt();
					if(ngay > 29) {
						if(thang == 2) {
							thang = 0;
							System.out.print("Tháng 2 không được > 29 ngày.");
							continue;
						}
						if(!kiemTraNgayThang(thang, ngay, nam)) {
							thang = 0;
							System.out.print(noti);
						}
					}
				}catch(Exception e) {
					thang = 0;
					System.out.print(noti);
				}
			}while(thang <= 0 || thang > 12);
			
			
			
			if(nam % 100 == 0 && nam % 4 ==0) {
				arrThang[1] = 29;
			}
			int sum = 0;
			for(int i = 0; i < thang-1; i++) {
					sum += arrThang[i];
			}
			sum += ngay;
			System.out.print("Tong ngay: "+sum);
		}
}
