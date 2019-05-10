#include <iostream>
#include <string>
using namespace std;
void sapxep(string str[], int n){
	int temp[n];
	for(int i = 0; i < n; i++){
		if(str[i] == "ONE") temp[i] = 1;
		if(str[i] == "TWO") temp[i] = 2;
		if(str[i] == "THREE") temp[i] = 3;
		if(str[i] == "FOUR") temp[i] = 4;
		if(str[i] == "FIVE") temp[i] = 5;
		if(str[i] == "SIX") temp[i] = 6;
		if(str[i] == "SEVEN") temp[i] = 7;
		if(str[i] == "EIGHT") temp[i] = 8;
		if(str[i] == "NINE") temp[i] = 9;
		if(str[i] == "TEN") temp[i] = 10;
	}
	for(int i = 0; i < n; i++){
		//cout<<temp[i]<<"+";
		for(int j = i + 1; j < n; j++){
			if(temp[i] > temp[j]){
				int t2 = temp[i];
				temp[i] = temp[j];
				temp[j] = t2;
				string t = str[i];
				str[i] = str[j];
				str[j] = t;
			}
		}
	}
}
int main()
{
	int t;
	string x = "la la la lo";
//	string test[5] = {"SIX","TWO", "ONE", "SIX", "EIGHT" };
//	sapxep(test, 5);
//	for(int i = 0; i < 5; i++){
//		cout<<test[i];
//	}
	cin>>t;
	cin.ignore();
	string outp = "";
	for(int i = 0; i < t; i++){
		int c; cin>>c;
		cin.ignore();
		string ctr[c];
		for(int j = 0; j < c; j++){
			//getline(cin, ctr[j]);
			cin>>ctr[j];
		}
		sapxep(ctr, c);
		for(int k = 0; k < c; k++){
			//cout<<ctr[k]<<" ";
			if(k == c) outp += ctr[k];
			else outp += ctr[k]+" ";
		}
		if(i < t) outp += "\n";
	}
	cout<<outp;
	return 0;
}

