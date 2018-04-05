#include <iostream>
#include <string>
using namespace std;
int fibo(int n)
{
	int a = 0, b = 1, c = a + b;
	n -= 2;
	while(n > 0)
	{
		c = a + b;
		a = b;
		b = c;
		n--;
	}
	return c;
}
int main()
{
	int n;
	cout<<"n= ";
	cin>>n;
	cout<<fibo(n);
	return 0;
}

