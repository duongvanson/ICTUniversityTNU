#include <iostream>
#include <math.h>
using namespace std;

bool kiemTraSCP(int num)
{
	int can = sqrt(num);
	if(can * can == num)
	{
		return true;
	}
	return false;
}
//Khong dung sqrt(x) in <math.h>
bool kiemTraSCP2(int num)
{
	for(int i = 1; i <= num / 2; i++)
	{
		if(i * i == num)
		{
			return true;
		}
	}
	return false;
}

int main()
{
	int num;
	cout<<"NUMBER: ";
	cin>>num;
	if(kiemTraSCP(num))
	{
		cout<<"SCP";
	}
	else
	{
		cout<<"!SCP";
	}
	return 0;
}

