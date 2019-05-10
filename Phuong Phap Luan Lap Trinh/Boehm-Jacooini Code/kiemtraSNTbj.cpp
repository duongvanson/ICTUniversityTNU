#include <iostream>
#include <math.h>
using namespace std;

bool kiemTraSNTBJ(int num)
{
	int i = 2;
	while(num < 2) 
	{
		return false;
	} // Cac so nguyen < 2 khong phai SNT
	while(i <= sqrt(num))
	{
		while(num % i == 0)
		{
			return false;
		}
		i++;
	}
	return true;
}

int main()
{
	int num;
	cout<<"NUMBER: ";
	cin>>num;
	while(kiemTraSNTBJ(num))
	{
		cout<<"SNT";
		return 0;
	}
	cout<<"!SNT";
	return 0;
}

