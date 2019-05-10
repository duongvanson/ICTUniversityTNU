#include <iostream>
using namespace std;
int a[10000], n;

void sapXepGiam(int a[], int n)
{
	for(int i = 0; i < n; i++)
	{
		for(int j = i+1; j < n; j++)
		{
			if (a[i] < a[j])
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
}

int main()
{
	cout<<"N= ";
	cin>>n;
	for(int i = 0; i < n; i++){
		cout<<"\tA["<<i+1<<"]= ";
		cin>>a[i];
	}
	sapXepGiam(a, n);
	cout<<"LAST: ";
	for(int i = 0; i < n; i++){
		cout<<a[i]<<" ";
	}
	return 0;
}

