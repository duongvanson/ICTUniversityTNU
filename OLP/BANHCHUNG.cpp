#include <iostream>
#include <string.h>
using namespace std;
int main()
{
	int t;
	cin>>t;
	cin.ignore();
	string inp[t];
	for(int i = 0; i < t; i++){
		getline(cin, inp[i]);
	}
	for(int i = 0; i < t; i++){
		string str = inp[i];
		int len = inp[i].length();
		int temp[len];
		for(int j = 0; j < len; j++){
			cout<<(int)(char)str[j]<<" ";
//			if(str[j].)
//				temp[j] = 1;
//			else temp[j] = 0;
		}
		for(int j = 0; j < len; j++){
			cout<<temp[j]<<" ";
		}
		cout<<endl;
	}
	return 0;
}

