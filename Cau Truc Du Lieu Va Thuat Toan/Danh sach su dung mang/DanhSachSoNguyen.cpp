/*
 *Created by Duong Van Son on 13/03/2018
 *Content: Du lieu danh sach mang so nguyen
 */
#include <iostream>
#include <string>
#include <ctime>
#include <stdlib.h>
#define N 100
using namespace std;
typedef int item;
//Dinh nghia cau truc
struct List
{
	item listInt[N];
	int size;
};
//Nhap danh  sach
void input(List *L)
{
	int n;
	cout<<"\tSinh danh sach bao nhieu phan tu: ";
	cin>>n;
	L->size=n;
	int i = 0, dem = 1;
	srand((time(NULL)));
	while(dem <= n)
		{
			L->listInt[i] = rand()%100+1;
			dem++;
			i++;
		}
	cout<<"\tOK! Danh sach ngau nhien da duoc tao!"<<endl;
}
//In danh sach
void output(List L)
{
	cout<<"\tDANH SACH: ";
	for(int i = 0; i < L.size; i++)
		cout<<L.listInt[i]<<" ";
	cout<<endl;
}
//Khoi tao danh sach
void init(List *L)
{
	L->size=0;
	cout<<"MANG <L> DA DUOC KHOI TAO."<<endl;
}
//Kiem tra danh sach rong
int isEmpty(List L)
{
	return (L.size == 0);
}
//Kiem tra danh sach day
int isFull(List L)
{
	return (L.size == N);
}
//Them mot phan tu "x" vao vi tri "k" trong ds L
void insert(List *L, item x, int k)
{
	if(L->size == N)
		cout<<"\tDanh sach day roi!";
	else if(k < 0 || k >L->size+1)
			cout<<"\tERROR! Vi tri them vao khong hop le!";
		else
		{
			for(int i = L->size; i >=k; i--)
			{
				L->listInt[i] = L->listInt[i-1];
			}
			L->listInt[k-1] = x;
			L->size++;
		}
	cout<<"\tOK! ["<<x<<"] Da duoc them vao danh sach."<<endl;
}
//Xoa mot phan tu tai vi tri "k" trong danh sach "L"
void deleteX(List *L, int k)
{
	if(k >= L->size)
		cout<<"\tERROR! Vi tri khong kha dung!"<<endl;
	else
	{
		for(int i = k-1; i < L->size; i++)
		{
			L->listInt[i] = L->listInt[i+1];
		}
		L->size--;
		cout<<"\tOK! Da xoa ["<<L->listInt[k-1]<<"] ra khoi danh sach!"<<endl;
	}
}
//Tim kiem phan tu co gia tri "x" trong danh sach "L"
void locate(List L, int x)
{
	int viTri, check = 0;
	for(int i = 0; i < L.size; i++)
		if(L.listInt[i] == x)
		{
			viTri = i;
			check = 1;	
		}
	if(check == 1)
		cout<<"\t["<<viTri<<"] la chi so cua ["<<x<<"] trong danh sach L."<<endl;
	else
		cout<<x<<"\tKhong ton tai trong danh sach."<<endl;
}
//Thay the phan tu co vi tri "p" bang mot phan tu "x" khac trong danh sach L
void replace(List *L, int p, int x)
{
	if(p < 0 || p >= L->size)
		cout<<"\tERROR! Vi tri khong hop le!";
	else
		L->listInt[p-1] = x;
}
void menu()
{
	cout<<"========================="<<endl;
	cout<<"1. Sinh danh sach ngau nhien"<<endl;
	cout<<"2. Hien thi danh sach"<<endl;
	cout<<"3. Kiem tra danh sach rong"<<endl;
	cout<<"4. Kiem tra danh sach day"<<endl;	
	cout<<"5. Them"<<endl;
	cout<<"6. Xoa"<<endl;
	cout<<"7. Tim kiem"<<endl;
	cout<<"8. Thay the"<<endl;
	cout<<"9. Xoa man hinh hien lai menu"<<endl;
	cout<<"0. Thoat"<<endl;
	cout<<"========================="<<endl;
}
void dislayMain()
{
	List L;
	init(&L);
	int chose, x, k;
	menu();
	while(true)
	{
		cout<<"You Chose: ";
		cin>>chose;
		switch(chose)
		{
			case 0:
				return;
				break;
			case 1:
				input(&L);
				break;
			case 2:
				output(L);
				break;
			case 3:
				if(isEmpty(L))
					cout<<"\t=> Danh sach rong."<<endl;
				else
					cout<<"\t=> Danh sach khong rong."<<endl;
				break;
			case 4:
				if(isFull(L))
					cout<<"\t=> Danh sach day."<<endl;
				else
					cout<<"\t=> Danh sach chua day."<<endl;
				break;
			case 5:
				cout<<"\tGia tri them: ";
				cin>>x;
				cout<<"\tVi tri them: ";
				cin>>k;
				insert(&L, x, k);
				break;
			case 6:
				cout<<"\tVi tri xoa: ";
				cin>>k;
				deleteX(&L, k);
				break;
			case 7:
				cout<<"\tGia tri tim kiem: ";
				cin>>x;
				locate(L, x);
				break;
			case 8:
				cout<<"\tVi tri can thay the: ";
				cin>>k;
				cout<<"\tGia tri thay the: ";
				cin>>x;
				replace(&L, k, x);
				break;
			case 9:
				system("cls");
				menu();
				break;
			default:
				cout<<"\tERROR! Chuc nang khong ton tai!"<<endl;
				break;
		}
	}
}
int main()
{
	dislayMain();
	return 0;
}

