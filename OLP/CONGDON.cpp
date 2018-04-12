#include <iostream>
using namespace std;
int main()
{
	float n, m;
	long double sum = 0;
	cin>>n>>m;
	while(n <= m)
	{
		sum += n*n;
		n++;
	}
	cout<<(long long)sum%(1000000000 + 7);
	return 0;
}

