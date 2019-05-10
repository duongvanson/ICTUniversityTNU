#include <iostream>
using namespace std;
int a[10000], n;

int timMax(int a[], int n)
{
	int max = a[0];
	for(int i = 0; i < n; i++)
	{
		if(a[i] > max)
		{
			max = a[i];
		}
	}
	return max;
}

int main()
{
	cout<<"N= ";
	cin>>n;
	for(int i = 0; i < n; i++){
		cout<<"\tA["<<i+1<<"]= ";
		cin>>a[i];
	}
	cout<<"MAX= "<<timMax(a, n);
	return 0;
}

