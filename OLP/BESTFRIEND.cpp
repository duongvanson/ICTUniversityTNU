#include <iostream>
using namespace std;
int tongUoc(int n)
{
	int sum = 0;
	for(int i = 1; i < n; i++)
	{
		if(n % i == 0)
			sum += i;
	}
	return sum;
}
int main()
{
	int m, n, um, un;
	cin>>m>>n;
	um = tongUoc(m);
	un = tongUoc(n);
	if((um == n) && (un == m))
		cout<<"YES";
	else
		cout<<"NO";
	return 0;
}

