#include <iostream>
using namespace std;
int a();
int main()
{
	int b = 0;
	b = a();
	cout<<b;
	return 0;
}
int a(int a){
	return a;
}

