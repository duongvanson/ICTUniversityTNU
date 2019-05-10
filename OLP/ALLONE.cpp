#include <iostream>
#include <math.h>
using namespace std;
bool ktv(float a, float b, float c){
	//cout<<"bc: "<<b*b+c*c<<endl;
	//cout<<"ha: "<<a*a<<endl;
	return (a*a == (b*b+c*c));	
}
int main()
{
	float a,b,c,d,e,f;
	int n;
	cin>>n;
	string outp = "";
	for(int i = 0; i < n; i++){
		cin>>a>>b>>c>>d>>e>>f;
		float p = (a+b+c)/2.0;
		float ha = 2.0*(sqrt(p*(p-a)*(p-b)*(p-c))/a);
		float hb = 2.0*(sqrt(p*(p-a)*(p-b)*(p-c))/b);
		float hc = 2.0*(sqrt(p*(p-a)*(p-b)*(p-c))/c);
		//cout<<p<<"-"<<ha<<endl;
		if((a/2 == d && b/2==e && c/2 == f)||(ktv(a,e,ha) && ktv(b,f,hb) && ktv(c,d,hc)))
		{
			if(i < n-1) outp+="YES\n";
			else outp+="YES";
		}
		else {
			if(i < n-1) outp+="NO\n";
			else outp+="NO";
		}
	}
	cout<<outp;
	return 0;
}

