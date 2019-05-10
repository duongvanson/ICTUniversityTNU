#include <iostream>
using namespace std;

int min3(int a, int b, int c)
{
	int min = a;
	if (min > b) 
	{ 
		min = b; 
	}
	if (min > c) 
	{ 
		min = c; 
	}
	return min;
}

int main()
{
	int a,b,c;
	cin>>a>>b>>c;
	cout<<min3(a,b,c);
	return 0;
}

