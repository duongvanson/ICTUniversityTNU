	#include <iostream>
using namespace std;
int a[10000], n;

int timMin(int a[], int n)
{
	int min = a[0];
	for(int i = 0; i < n; i++)
	{
		if(a[i] < min)
		{
			min = a[i];
		}
	}
	return min;
}

int main()
{
	cout<<"N= ";
	cin>>n;
	for(int i = 0; i < n; i++){
		cout<<"\tA["<<i+1<<"]= ";
		cin>>a[i];
	}
	cout<<"MIN= "<<timMin(a, n);
	return 0;
}

