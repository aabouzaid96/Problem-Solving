#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
using namespace std;
int main(){

	long long  b,ret;
	int a, t;
	int x[10][4] = { { 1 }, { 2, 4, 8, 6 }, { 3, 9, 7, 1 }, { 4, 6 }, { 5 }, { 6 }, { 7, 9, 3, 1 }, { 8, 4, 2, 6 }, { 9, 1 }, { 0 } };
	int z[10] = { 1, 4, 4, 2, 1,1, 4, 4, 2,1};
	cin >> t;

	while (t){
		cin >> a >> b;
		
		int f = a % 10 ;
		if (b == 0)cout << 1 << endl;
		else if (f == 0)cout << 0<<endl;
		else{
		
			 ret = b % z[f - 1];
			if (ret == 0) ret = z[f - 1];
			else if (ret == z[f - 1]) ret = 0;
			 cout << x[f - 1][ret - 1]<<endl; 
		}
		t--;
		
	}

}
