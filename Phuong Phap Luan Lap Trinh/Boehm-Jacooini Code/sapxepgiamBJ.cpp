#include <iostream>
using namespace std;
int a[10000], n;

void sapXepGiamBJ(int a[], int n)
{
	int i = 0;
	int j = 0;
	int temp = 0;
	while(i < n)
	{
		j = i + 1;
		while(j < n)
		{
			while(a[i] < a[j])
			{
				temp = a[i];
				a[i] =  a[j];
				a[j] = temp;
			}
			j++;
		}
		i++;
	}
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
	sapXepGiamBJ(a, n);
	cout<<"LAST: ";
	i = 0;
	while(i < n)
	{
		cout<<a[i]<<" ";
		i++;
	}
	return 0;
}

