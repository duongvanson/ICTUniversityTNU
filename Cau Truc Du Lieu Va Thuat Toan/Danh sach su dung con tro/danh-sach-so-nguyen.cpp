//Created by Duong Van Son on 04/04/2018
#include <iostream>
#include <string>
#include <cstdlib>
#include <windows.h>
using namespace std;
typedef struct Node
{
	int Data;
	Node *Next;
};
typedef Node *pList;
//Khoi tao danh sach rong
void init(pList &L)
{
	L = NULL;
}
//Kiem tra rong
bool isEmpty(pList L)
{
	return (L == NULL);
}
//Khoi tao Node
Node *makeNode(int x)
{
	Node* p;
	p = (Node*)malloc(sizeof(Node));
	p->Data = x;
	p->Next = NULL;
	return p;
}
//Dem so phan tu cua danh sach
int count(pList L)
{
	int dem = 0;
	Node *p = L;
	while(p!= NULL)
	{
		dem++;
		p = p->Next;
	}
	return dem;
}

//Hien thi danh sach
void hienThi(pList L)
{
	Node *P  = L;
    while (P != NULL)
    {
        cout<<P->Data<<" ";
        P = P->Next;
    }
}
//Them vao dau danh sach
void insertFirst(pList &L, int x)
{
	Node *p;
	p = makeNode(x);
	p->Next = L;
	L = p;
}
//Them vao cuoi danh sach
void insertLast(pList &L, int x)
{
	Node *M = L;
	Node* P;
	while (M->Next != NULL)
		M = M->Next;
	P = makeNode(x);
	M->Next = P;
}
//Them vao vi tri k
void insertK(pList &L, int x, int k)
{
	Node *M, *N = L; 
    int i=1;
    if (k<1 || k> count(L)+1) cout<<"Vi tri chen khong hop le !";
    else
    {
        M = makeNode(x);
        if (k == 1) insertFirst(L,x);
        else
        {
            while (N != NULL && i != k-1)
            {
                i++;
                N = N->Next;
            }
            M->Next = N->Next; 
            N->Next = M;
        }
    }
}
//Xoa phan tu dau danh sach
void deleteFirst(pList &L)
{
	L = L->Next;
}
//Xoa phan tu thu k
void deleteK(pList &L, int k)
{
	int i = 1;
	Node* M = L;
	while(M != NULL && k-1 != i)
	{
		M = M->Next;
		i++;
	}
	M->Next = M->Next->Next;
}
//Tim phan tu
int search (pList L, int x)
{
    Node *M=L; 
    int i=1;
    while (M != NULL && M->Data != x)
    {
        M = M->Next;
        i++;
    }
    if (M != NULL) return i;
    else return 0;
}
//Nhap danh sach
void nhap(pList &L)
{
	Node* N;
	int x;
	int n;
	init(L);
	cout<<"So PT: ";
	cin>>n;
	for(int i = 0; i < n; i++)
	{
		//N = (Node*)malloc(sizeof(Node));
		cout<<"\tPT ["<<i+1<<"]= ";
		cin>>x;
		//N = makeNode(x);
		if(L != NULL)
			insertLast(L, x);
		else
			insertFirst(L, x);
//		if(N != NULL)
//		{
//			N->Data = x;
//			N->Next = L;
//			L = N;
//		}
//		else
//		{
//			cout<<"Loi cap phat bo nho."<<endl;
//		}
	}
}
void Menu()
{
	cout<<"=========Lua chon=========="<<endl;
	cout<<"1. Kiem tra rong"<<endl;
	cout<<"2. Tao Node P chua x"<<endl;
	cout<<"3. Dem so phan tu"<<endl;
	cout<<"4. Them vao dau ds"<<endl;
	cout<<"6. Them vao vi tri k"<<endl;
	cout<<"7. Xoa dau ds"<<endl;
	cout<<"8. Xoa vi tri k"<<endl;
	cout<<"9. Tim kiem phan tu"<<endl;
	cout<<"10. Nhap du lieu "<<endl;
	cout<<"11. Xuat du lieu"<<endl;
	cout<<"12. Xoa man hinh hien menu"<<endl;
	cout<<"0. Thoat"<<endl;
	cout<<"==========================="<<endl;
}
int main()
{
	pList L;
	Node *P;
	init(L);
	int x, k;
	Menu();
	int chon;
	do
	{
		cout<<"\n==>> Chon: ";
		cin>>chon;
		switch(chon)
		{
			case 0:
				return 0;
				break;
			case 1:
				if(isEmpty(L))
					cout<<"Danh sach rong"<<endl;
				else
					cout<<"Not rong"<<endl;
				break;
			case 2:
				cout<<"\tNhap x: ";
				cin>>x;
				P = makeNode(x);
				cout<<"\tKhoi tao thanh cong!"<<endl;
				break;
			case 3:
				cout<<"\tSL PT: "<<count(L)<<endl;
				break;
			case 4:
				cout<<"\tGT them: ";
				cin>>x;
				insertFirst(L, x);
				break;
			case 5:
				cout<<"\tGT them: ";
				cin>>x;
				insertLast(L, x);
				break;
			case 6:
				cout<<"\tGT them: ";
				cin>>x;
				cout<<"\tVT Them: ";
				cin>>k;
				insertK(L, x, k);
				break;
			case 7:
				deleteFirst(L);
				cout<<"\tDEL OK!"<<endl;
				break;
			case 8:
				cout<<"\tVi tri xoa: ";
				cin>>k;
				deleteK(L, k);
				cout<<"\tDEL OK!"<<endl;
				break;
			case 9:
				cout<<"\tGia tri tim: ";
				cin>>x;
				cout<<"\tVi tri: "<<search(L, x);
				break;
			case 10:
				nhap(L);
				break;
			case 11:
				hienThi(L);
				break;
			case 12:
				system("cls");
				Menu();
				break;
			default:
				cout<<"\tKhong hop le!"<<endl;
				break;
		}
	} while(chon != 0);
	
	return 0;
}

