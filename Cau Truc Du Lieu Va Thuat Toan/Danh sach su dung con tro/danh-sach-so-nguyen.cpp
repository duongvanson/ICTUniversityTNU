//Created by Duong Van Son on 04/04/2018
#include <iostream>
#include <string>
using namespace std;
typedef struct Node
{
	int Data;
	Node *Next;
};
typedef struct Node *pList;
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
void makeNode(Node *p, int x)
{
	p = (Node*)malloc(sizeof(Node));
	p->Data = x;
	p->Next = Node;
}
int main()
{
	return 0;
}

