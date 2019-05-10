#include <iostream>
using namespace std;
int a[10000], n;

int timMinBJ(int a[], int n)
{
	int min = a[0];
	int i = 0;
	while(i < n)
	{
		while(min > a[i])
		{
			min = a[i];
		}
		i++;
	}
	return min;
}

int main()
{
	cout<<"N= ";
	cin>>n;
	int i = 0;
	while(i < n)
	{
		cout<<"\tA["<<i+1<<"]= ";
		cin>>a[i];
		i++;
	}
	cout<<"MIN= "<<timMinBJ(a, n);
	return 0;
}

