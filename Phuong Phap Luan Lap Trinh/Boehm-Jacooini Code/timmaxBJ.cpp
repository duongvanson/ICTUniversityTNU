#include <iostream>
using namespace std;
int a[10000], n;

int timMaxBJ(int a[], int n)
{
	int max = a[0];
	int i = 0;
	while(i < n)
	{
		while(max < a[i])
		{
			max = a[i];
		}
		i++;
	}
	return max;
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
	cout<<"MAX= "<<timMaxBJ(a, n);
	return 0;
}

