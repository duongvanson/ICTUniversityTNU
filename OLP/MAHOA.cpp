#include <iostream>
using namespace std;
int main()
{
	int n;
	cin>>n;
	int a[100], x = 0;
	int min = -1;
	for(int i = 1; i <= n/2; i++)
	for(int j = 1; j <= n/2; j++)
	{
		if(i * j == n)
		{
			a[x] = (i*10)+j;
			if(x == 0) min = a[x];
			else if(a[x] < min) min = a[x];
			x++;
		}
	}
	cout<<min;
	return 0;
}

