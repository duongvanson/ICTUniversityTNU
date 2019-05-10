#include <iostream>
using namespace std;

int max3bj(int a, int b, int c)
{
	int max = a;
	while (b > max)
	{
		max = b
	}
	while (c > max) 
	{ 
		max = c; 
	}
	return max;
}

int main()
{
	int a,b,c;
	cin>>a>>b>>c;
	cout<<max3bj(a,b,c);
	return 0;
}

