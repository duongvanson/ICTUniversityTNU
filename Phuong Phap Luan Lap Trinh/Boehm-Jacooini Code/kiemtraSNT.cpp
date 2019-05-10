#include <iostream>
#include <math.h>
using namespace std;

bool kiemTraSNT(int num)
{
	if(num < 2)
	{ 
		return false;
	}// Cac so nguyen < 2 khong phai SNT
	for(int i = 2; i <= sqrt(num); i++)
	{
		if(num % i == 0)
		{
			return false;
		}
	}
	return true;
}

int main()
{
	int num;
	cout<<"NUMBER: ";
	cin>>num;
	if(kiemTraSNT(num))
	{
		cout<<"SNT";
	}
	else
	{
		cout<<"!SNT";
	}
	return 0;
}

