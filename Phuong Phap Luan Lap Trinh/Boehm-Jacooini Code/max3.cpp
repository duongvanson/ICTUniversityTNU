#include <iostream>
using namespace std;

int max3(int a, int b, int c)
{
	int max = a;
	if (max < b)
	{
		max = b;
	}
	if (max < c)
	{
		max = c;
	}
	return max;
}

int main()
{
	int a,b,c;
	cin>>a>>b>>c;
	cout<<max3(a,b,c);
	return 0;
}

