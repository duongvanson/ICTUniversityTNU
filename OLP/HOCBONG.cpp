#include <iostream>
#include <algorithm>
using namespace std;
int tim(int a[], int n)
{
	int vt = 0;
	for(int i = 0; i < n; i++)
	{
		if(a[i] > a[vt])
			vt = i;
	}
	return vt;
}
int main()
{
	int sl, slhb;
	cin>>sl>>slhb;
	int point[sl];
	for(int i = 0; i < sl; i++)
		cin>>point[i];
		
	int SLHB[slhb], x = 0;
	
	while(slhb != 0)
	{
		int vt = tim(point, sl);
		SLHB[x] = point[vt];
		point[vt] = -1;
		slhb--;
		x++;
	}
	
	sort(SLHB, SLHB+x);
	reverse(SLHB, SLHB+x);
	
	for(int i = 0; i < x; i++)
	{
		if(i < x-1)
			cout<<SLHB[i]<<" ";
		else
			cout<<SLHB[i];
	}
	return 0;
}

