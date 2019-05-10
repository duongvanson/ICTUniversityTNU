#include <iostream>
using namespace std;

int min3bj(int a, int b, int c)
{
	int min = a;
	while (min > b) 
	{ 
		min = b; 
	}
	while (min > c) 
	{ 
		min = c; 
	}
	return min;
}

int main()
{
	int a,b,c;
	cin>>a>>b>>c;
	cout<<min3bj(a,b,c);
	return 0;
}

