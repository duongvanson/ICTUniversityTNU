#include <iostream>
#include <string>
using namespace std;
int ToHop(int, int);
int main()
{
	int k, n;
	cout<<"Input(k,n): ";
	cin>>k>>n;
	cout<<"C(k, n)= "<<ToHop(k, n)<<endl;
	return 0;
}
int ToHop(int k, int n)
{
	if(n == k || k == 0)
		return 1;
	else
		return ToHop(k-1, n-1) + ToHop(k, n-1);
}
