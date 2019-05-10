#include <iostream>
using namespace std;
int main()
{
	int n;
	cin>>n;
	cin.ignore();
	string inp[n];
	for(int i = 0; i< n; i++){
		getline(cin, inp[i]);
	}
	for(int i = 0; i < n; i++){
		string str = inp[i];
		string temp = "";
		for(int j = 0; j < str.length(); j++){
			switch(str[j]){
				case 'a':
				case 'b':
				case 'c':
					temp +="2";
					break;
				case 'd':
				case 'e':
				case 'f':
					temp +="3";
					break;
				case 'g':
				case 'h':
				case 'i':
					temp +="4";
					break;
				case 'j':
				case 'k':
				case 'l':
					temp +="5";
					break;
				case 'm':
				case 'n':
				case 'o':
					temp +="6";
					break;
				case 'p':
				case 'q':
				case 'r':
				case 's':
					temp +="7";
					break;
				case 't':
				case 'u':
				case 'v':
					temp +="8";
					break;
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					temp +="9";
					break;
				case ' ':
					temp +="0";
					break;
				default:
					break;
			}
		}
		if(i == n)
			cout<<temp;
		else cout<<temp<<endl;
	}
	return 0;
}

