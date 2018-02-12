    #define _CRT_SECURE_NO_DEPRECATE
    #include<iostream>
    #include<algorithm>
    #include<vector>
    #include<cmath>
    #include<string.h> 
    #include<string> 
    #include<numeric>
    #include <cstdio>
    #include<queue>
    using namespace std;
     
    #include <iostream>
    #include <queue>
    #include <string.h>
    using namespace std;
     
     
    char grid[182][182];
    int dis[182][182];
            //  up  down  right left 
    int dx[] = { 1, -1,    0,    0 };
    int dy[] = { 0, 0,     1,   -1 };
     
    class node{
    public:
    	int x, y, d;
    };
    queue<node>Q;
    int main(){
    	int t;
    	cin >> t;
    	while (t--){
    	int n, m;
    	cin >> n >> m;
    	node cur;
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < m; j++)
    			cin >> grid[i][j];
    	memset(dis, -1, sizeof dis);
     
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < m; j++)
    			if (grid[i][j] == '1'){
    		cur.x = i;
    		cur.y = j;
    		cur.d = 0;
    		Q.push(cur);
    			}
     
    	while (Q.size()){
    		cur = Q.front();
    		Q.pop();
     
    		if (dis[cur.x][cur.y] != -1) continue;
    		dis[cur.x][cur.y] = cur.d;
     
    		for (int i = 0; i < 4; i++)
    		{
    			node temp;
    			temp.x = cur.x + dx[i];
    			temp.y = cur.y + dy[i];
    			temp.d = cur.d + 1;
    			if (temp.x < 0 || temp.x >= n || temp.y < 0 || temp.y >= m) continue;
    			if (dis[temp.x][temp.y] == -1)
    				Q.push(temp);
    		}
    	}
     
    	for (int i = 0; i < n; i++){
    		for (int j = 0; j < m; j++)
    			cout << dis[i][j] << " ";
    		cout << endl;
    	}
     
    }
    }
     
    /*
    3 4
    0001
    0011
    0110
     
    */ 
