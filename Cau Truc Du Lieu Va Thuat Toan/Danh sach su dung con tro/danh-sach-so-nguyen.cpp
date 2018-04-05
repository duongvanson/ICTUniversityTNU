//Created by Duong Van Son on 04/04/2018
#include <iostream>
#include <string>
#include <cstdlib>
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
	L == NULL;
}
//Kiem tra rong
bool isEmpty(pList L)
{
	return (L == NULL);
}
//Khoi tao Node
Node* makeNode(Node *p, int x)
{
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
	while(p != NULL)
	{
		dem++;
		p = p->Next;
	}
	return dem;
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
		N = (Node*)malloc(sizeof(Node));
		cout<<"\tPT ["<<i+1<<"]= ";
		cin>>x;
		if(N != NULL)
		{
			N->Data = x;
			N->Next = L;
			L = N;
		}
		else
		{
			cout<<"Loi cap phat bo nho."<<endl;
		}
	}
}
//Hien thi danh sach
void hienThi(pList L)
{
	Node *P=L;
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
	p = makeNode(p, x);
	p->Next = L;
	L = p;
}
//Them vao vi tri k
void insertK(pList &L, int x, int k)
{
	Node *M, *N = L; 
    int i=1;
    if (k<1 || k> count(L)+1) cout<<"Vi tri chen khong hop le !";
    else
    {
        M = makeNode(M,x);
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
//Xoa phan tu dau tien
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
int Search (List L, item x)
{
    Node *M=L; 
    int i=1;
    while (M != NULL && M->Data != x)
    {
        M = M->next;
        i++;
    }
    if (M != NULL) return i;
    else return 0;
}
int main()
{
	pList L;
	nhap(L);
	return 0;
}

