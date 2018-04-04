#include <iostream>
#include <string>
using namespace std;
long int GiaiThua(int );
int main()
{
	int n;
	cout<<"GT: ";
	cin>>n;
	cout<<n<<"!= "<<GiaiThua(n);
	return 0;
}
long int GiaiThua(int n)
{
	if(n == 0)
		return 1;
	else
		return n*GiaiThua(n-1);
}

