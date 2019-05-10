#include <iostream>
#include <math.h>
using namespace std;

bool kiemTraSCPBJ(int num)
{
	int can = sqrt(num);
	while(can * can == num)
	{
		return true;
	}
	return false;
}
//Khong dung sqrt(x) in <math.h>
bool kiemTraSCPBJ2(int num)
{
	int i = 1;
	while(i <= num / 2)
	{
		while(i * i == num)
		{
			return true;
		}
		i++;
	}
	return false;
}

int main()
{
	int num;
	cout<<"NUMBER: ";
	cin>>num;
	if(kiemTraSCPBJ(num))
	{
		cout<<"SCP";
	}
	else
	{
		cout<<"!SCP";
	}
	return 0;
}

