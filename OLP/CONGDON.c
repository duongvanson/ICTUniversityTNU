#include <stdio.h>
int main()
{
	float x, y;
	long long sum = 0;
	scanf("%f %f", &x, &y);
	for(; x <= y; x++)
	{
		sum += x*x;
	}
	printf("%d", sum%(1000000000 + 7));
	return 0;
}

