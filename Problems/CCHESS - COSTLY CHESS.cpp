#define _CRT_SECURE_NO_WARNINGS
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
#include <math.h>
#include <stack>
#include <list>
#include <map>
#include <set>
#include<sstream>
#include<time.h>
 
#define SI1(v)  scanf("%d",&v)					    // int 1
#define SI2(v1,v2)  scanf("%d%d",&v1,&v2)	     	// int 2
#define SI3(v1,v2,v3)  scanf("%d%d%d",&v1,&v2,&v3)  // int 3
#define SLL1(v)  scanf("%lld",&v)					// long long 1
#define SLL2(v1,v2)  scanf("%lld%lld",&v1,&v2)      // long long 2 
#define PI1(v)  printf("%d\n",v)					    // int 1
#define PI2(v1,v2)  printf("%d %d\n",v1,v2)	     	// int 2
#define PLL1(v)  printf("%lld\n",v)					// long long 1
#define Line    printf("\n");
typedef long long ll;
using namespace std;
int dx[] = { 0, 1, 0, -1, 0, -1, -1, -1 };
int dy[] = { -1, 0, 1, 0, 1, 1, 0, -1 };
 
int Kx[] = { -2, -2, -1, -1, 1, 1, 2, 2 },
Ky[] = { -1, 1, -2, 2, -2, 2, -1, 1 };
int N = 1e9;
int dis[8][8];
bool valid(int x, int y){
	if (x < 0 || x >= 8 || y < 0 || y >= 8) return 1;
	return 0;
 
}
 
int cost(int x1, int y1, int x2, int y2){
	return x1*x2 + y1*y2;
}
void Dijkstra(int x, int y){
 
	priority_queue < pair<int, pair<int, int> >,
		vector< pair<int, pair<int, int> > >,
		greater<pair<int, pair<int, int> > > >PQ;
 
 
	for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++)  dis[i][j] = N;
 
 
	PQ.push(make_pair(0, make_pair(x, y)));
	dis[x][y] = 0;
 
	while (PQ.size()){
		int curx = PQ.top().second.first,
			cury = PQ.top().second.second,
			w = PQ.top().first;
		PQ.pop();
 
		if (dis[curx][cury] <w)continue;
 
		for (int i = 0; i < 8; i++){
			int tmpx, tmpy;
			tmpx = curx + Kx[i];
			tmpy = cury + Ky[i];
 
			if (valid(tmpx, tmpy))continue;
			int c = cost(curx, cury, tmpx, tmpy);
			if (dis[curx][cury] + c < dis[tmpx][tmpy]){
				dis[tmpx][tmpy] = dis[curx][cury] + c;
				PQ.push(make_pair(dis[tmpx][tmpy], make_pair(tmpx, tmpy)));
			}
 
		}
	}
 
 
 
}
int main(){
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	//freopen("output.txt", "w", stdout);
#endif
 
	int sx, sy, ex, ey;
	while (scanf("%d%d%d%d", &sx, &sy, &ex, &ey) != -1){
 
		Dijkstra(sx, sy);
 
		PI1(dis[ex][ey]);
	}
}
