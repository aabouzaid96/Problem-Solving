    #define _CRT_SECURE_NO_DEPRECATE
    #include<istream>
    #include<iostream>
    #include<algorithm>
    #include<vector>
    #include<cmath>
    #include<string.h>
    #include<string>
    #include <stdio.h>
    #include<cstdio>
    #include<set> 
    #include<queue>
    #include<map>
    #include <cctype>
    using namespace std;
     
    class node
    {
    public:
    	int ind, cost;
    };
     
    bool operator < (node a, node b)
    {
    	if (a.cost != b.cost) return a.cost < b.cost;
    	return a.ind < b.ind;
    }
     
    int n, m, st, en;
    	vector<int> arr[100001], c[100001];
    	int dis[100001];
    	
     
    /*int dijkstra()
    {
    	node cur;
    	memset(dis, -1, sizeof dis);
     
    	cur.ind = st;
    	cur.cost = 0;
    	S.insert(cur);
     
    	while (S.size())
    	{
    		cur = *S.begin();
    		S.erase(S.begin());
     
    		if (dis[cur.ind] != -1) continue;
    		dis[cur.ind] = cur.cost;
    		if (cur.ind == en) return cur.cost;
     
    		for (int i = 0; i<arr[cur.ind].size(); i++)
    		{
    			node temp;
    			temp.ind = arr[cur.ind][i];
    			temp.cost = cur.cost + c[cur.ind][i];
    			if (dis[temp.ind] == -1)
    				S.insert(temp);
    		}
    	}
    	return -1;
    }*/
     
    int main()
    {
    	int t;
    	cin >> t;
    	while (t--){
    		int i, f, s, cost;
    		set<node> S;
    		cin >> n >> m >> st >> en;
    		for (i = 0; i < m; i++)
    		{
    			cin >> f >> s >> cost;
    			arr[f].push_back(s);
    			c[f].push_back(cost);
     
    			arr[s].push_back(f);
    			c[s].push_back(cost);
    		}
    		 
    		bool f1 = false;
    		node cur;
    		memset(dis, -1, sizeof dis);
     
    		cur.ind = st;
    		cur.cost = 0;
    		S.insert(cur);
     
    		while (S.size())
    		{
    			cur = *S.begin();
    			S.erase(S.begin());
     
    			if (dis[cur.ind] != -1) continue;
    			dis[cur.ind] = cur.cost;
    			if (cur.ind == en) {
    				cout << cur.cost<<endl;
    				f1 = true;
    				break;
    			}
    			for (int i = 0; i < arr[cur.ind].size(); i++)
    			{
    				node temp;
    				temp.ind = arr[cur.ind][i];
    				temp.cost = cur.cost + c[cur.ind][i];
    				if (dis[temp.ind] == -1)
    					S.insert(temp);
    			}
    		}
     
    		if (!f1)cout << "NONE\n";
     
    	}
    			
     
    }
     
