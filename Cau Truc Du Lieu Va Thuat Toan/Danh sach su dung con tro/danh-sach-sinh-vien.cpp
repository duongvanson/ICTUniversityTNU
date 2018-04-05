//Created by Duong Van Son on 05/04/2018
#include <iostream>
#include <string>
#include <cstdlib>
#include <windows.h>
using namespace std;
typedef struct SinhVien
{
	string MaSV;
	string HoTen;
	string Lop;
	float DiemTB;	
};
typedef struct Node
{
	SinhVien Data;
	Node* Next;
};
typedef Node* listSV;
//Khoi tao danh sach rong
void init(listSV &LSV)
{
	LSV = NULL;
}
//Nhap sinh vien
void nhapSV(SinhVien sv)
{
	cin.ignore();
	cout<<"\tMa SV: ";
	getline(cin, sv.MaSV);
	cout<<"\tHo ten: ";
	getline(cin, sv.HoTen);
	cout<<"\tLop: ";
	getline(cin, sv.Lop);
	cout<<"\tDiem TB: ";
	cin>>sv.DiemTB;
	cin.ignore();
}
//Hien sinh vien
void xuatSV(SinhVien sv)
{
	cout<<endl<<sv.MaSV<<"\t"<<sv.HoTen<<"\t"<<sv.Lop<<"\t"<<sv.DiemTB;
}
//Khoi tao mot node sinh vien
Node* makeNode(SinhVien sv)
{
	Node* p;
	p->Data = sv;
	p->Next = NULL;
	return p;
}
//Kiem tra danh sach rong
bool isEmpty(listSV LSV)
{
	return (LSV == NULL);
}
//Dem so phan tu cua danh sach
int count(listSV lsv)
{
	Node *p = lsv;
	int i = 0;
	while(p->Next != NULL)
	{
		p = p->Next;
		i++;
	}
	return i;
}
//Them vao dau danh sach
void themDau(listSV &lsv, SinhVien sv)
{
	Node *p;
	p = makeNode(sv);
	p->Next = lsv;
	lsv = p;
}
//Them vao cuoi danh sach
void themCuoi(listSV &lsv, SinhVien sv)
{
	Node *M = lsv;
	Node* P;
	while (M->Next != NULL)
		M = M->Next;
	P = makeNode(sv);
	M->Next = P;
}
void Menu()
{
	cout<<"======================="<<endl;
	cout<<"1. Khoi tao"<<endl;
	cout<<"2. Kiem tra rong"<<endl;
	cout<<"3. Dem so phan tu ds"<<endl;
	cout<<"4. Them dau"<<endl;
	cout<<"5. Them cuoi"<<endl;
	cout<<""<<endl;
	cout<<""<<endl;
	cout<<""<<endl;
	cout<<"======================="<<endl;
}
int main()
{
	listSV LSV;
	init(LSV);
	SinhVien sv;
	int k;
	Node *p;
	Menu();
	int chon;
	do
	{
		cout<<"Chon: ";
		cin>>chon;
		switch(chon)
		{
			case 0:
				return 0;
				break;
			case 1:
				init(LSV);
				cout<<"\tKhoi tao thanh cong!"<<endl;
				break;
			case 2:
				if(isEmpty(LSV))
					cout<<"\tDanh sach rong."<<endl;
				else
					cout<<"\tKhong rong."<<endl;
				break;
			case 3:
				cout<<"\tCount: "<<count(LSV);
				break;
			case 4:
				cout<<"\tNhap thong tin sinh vien: "<<endl;
				nhapSV(sv);
				themDau(LSV, sv);
				cout<<"\tOK!"<<endl;
				break;
			case 5:
				cout<<"\tNhap thong tin sinh vien: "<<endl;
				nhapSV(sv);
				themCuoi(LSV, sv);
				cout<<"\tOK!"<<endl;
				break;
			default:
				cout<<"\tKhong hop le"<<endl;
				break;
		}	
	} while(chon != 0);
	return 0;
}

