    #define _CRT_SECURE_NO_DEPRECATE
    #include<iostream>
    #include<algorithm>
    #include<vector>
    #include<cmath>
    #include<string.h>
    #include<string>
    #include <stdio.h>
    #include<cstdio>
    #include<set> 
    using namespace std;
    pair<int, int >a[100];
    /*bool cmp(pair<int, int>y, pair<int, int>x){
    	if (y.first <= x.first) return 1;
    	return 0;
    }*/
    int main(){
    	int t, n;
    	cin >> t;
    	while (t--){
    		cin >> n;
    		for (int i = 0; i < n * 2; i++)
    		{
    			cin >> a[i].first;
    			if (i % 2 == 0) a[i].second = 1;
    			else a[i].second = -1;
    		}
    		sort(a, a + n*2);
    		
    		int sum = 0,Mx=0;
    		
    		for (int i = 0; i < n * 2; i++){
    			if (a[i].second == 1){
    				sum += 1;
    				Mx = max(Mx, sum);
    			}
    			else sum -= 1;
    		}
    			
     
    	
    		cout << Mx << endl;
    	}
    } 
