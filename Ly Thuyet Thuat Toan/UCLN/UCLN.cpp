#include <iostream>
#include <string>
using namespace std;
int UCLN(int , int );
int main()
{
	int a, b;
	cout<<"a, b= ";
	cin>>a>>b;
	cout<<"UCLN("<<a<<","<<b<<")= "<<UCLN(a, b);
	return 0;
}
int UCLN(int a, int b)
{
	if(a == b)
		return a;
	else if(a > b)
			return UCLN(a-b, b);
		else
			return UCLN(a, b-a);
}

