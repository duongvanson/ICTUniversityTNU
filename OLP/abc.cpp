#include <iostream>
using namespace std;
int main()
{
	string a[2];
	for(int i = 0; i < 2; i++){
		getline(cin, a[i]);
	}
	for(int i = 0; i < 2; i++){
		string t = a[i];
		char x = t[0];
		if(x == 'l')
			cout<<"DAMNIT"<<endl;
	}
	return 0;
}

