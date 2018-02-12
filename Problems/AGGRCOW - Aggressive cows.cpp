    #define _CRT_SECURE_NO_DEPRECATE
    #include <functional>
    #include <algorithm>
    #include <iostream>
    #include <iomanip>
    #include <numeric>
    #include <cstring>
    #include <string>
    #include <cstdio>
    #include <vector>
    #include <bitset>
    #include <queue>
    #include <cmath>
    #include <stack>
    #include <list>
    #include <map>
    #include <set>
    #include<sstream>
     
    #define SI1(v)  scanf("%d",&v)					    // int 1
    #define SI2(v1,v2)  scanf("%d%d",&v1,&v2)	     	// int 2
    #define SI3(v1,v2,v3)  scanf("%d%d%d",&v1,&v2,&v3)  // int 3
    #define SLL1(v)  scanf("%lld",&v)					// long long 1
    #define SLL2(v1,v2)  scanf("%lld%lld",&v1,&v2)      // long long 2 
    #define PI1(v)  printf("%d\n",v)					    // int 1
    #define PI2(v1,v2)  printf("%d %d",v1,v2)	     	// int 2
    #define PLL1(v)  printf("%lld",v)					// long long 1
    typedef long long ll;
    using namespace std;
    int a[100000],n,c;
    bool solve(int mid){
    	int sum = a[0],cnt=1,cur=a[0];
    	for (int i = 1; i < n; i++){
    		if (a[i] - cur >= mid)
    			cnt++, cur = a[i];
    	}
    	if (cnt >= c) return 1;
    	return 0;
    }
    int BS(){
    	int st = 1, end = a[n-1];
    	int res;
    	while (st <= end){
    		int mid = st + (end - st) / 2;
    		if (solve(mid)){
    			st = mid + 1;
    			res = mid;
    		}
    		else {
    			end = mid - 1;
    		}
    	}
    	return res;
     
    }
    int main() {
    	//freopen("read.txt", "r", stdin);
    	//freopen("output.txt", "w", stdout);
     
    	int t;
    	SI1(t);
    	while (t--){
    		
    		SI2(n, c);
    		for (int i = 0; i < n; i++)SI1(a[i]);
    		sort(a, a + n);
    		printf("%d\n", BS());
     
    	}
    	
    } 
