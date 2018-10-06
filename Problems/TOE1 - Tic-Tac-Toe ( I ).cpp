#include<bits/stdc++.h>
using namespace std;
#define SI1(v)  scanf("%d",&v)					    // int 1
#define SI2(v1,v2)  scanf("%d%d",&v1,&v2)	     	// int 2
#define SI3(v1,v2,v3)  scanf("%d%d%d",&v1,&v2,&v3)  // int 3
#define SLL1(v)  scanf("%lld",&v)					// long long 1
#define SLL2(v1,v2)  scanf("%lld%lld",&v1,&v2)      // long long 2
#define PI1(v)  printf("%d\n",v)					    // int 1
#define PI2(v1,v2)  printf("%d %d\n",v1,v2)	     	// int 2
#define PLL1(v)  printf("%lld\n",v)					// long long 1
#define Line    printf("\n");
#define yes    printf("YES\n");
#define no    printf("NO\n");
#define Retyes    return printf("YES\n"),0;
#define Retno    return printf("NO\n"),0;
#define ll long long
using namespace std;

/*
...
...
...
*/

bool winning(string s){

  // vertical
    if((s[0]!='.' && s[0]==s[1] && s[1]==s[2]) ||
       (s[3]!='.' && s[3]==s[4] && s[4]==s[5]) ||
       (s[6]!='.' && s[6]==s[7] && s[7]==s[8]) ) return 1;

  // horizontal
    if((s[0]!='.' && s[0]==s[3] && s[3]==s[6]) ||
       (s[1]!='.' && s[1]==s[4] && s[4]==s[7]) ||
       (s[2]!='.' && s[2]==s[5] && s[5]==s[8]) ) return 1;

// diagonal
    if((s[0]!='.' && s[0]==s[4] && s[4]==s[8]) ||
       (s[2]!='.' && s[2]==s[4] && s[6]==s[7]) ) return 1;

return 0;
}

int main()
{

#ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
#endif

    int t;
    SI1(t);
    while(t--)
    {
    string board="",row;
    for(int i=0;i<3;i++){
        cin>>row;
        board+=row;
    }
string start=".........";

    queue< pair<string, bool> >Q;
    Q.push({start,1});
    int ans=0;
    while(!Q.empty()){
        string cur_b=Q.front().first;
        bool cur_s=Q.front().second;
        Q.pop();

    if(board == cur_b) {ans=1; break;}
    if(winning(cur_b)) continue;

    for(int i=0;i<9;i++){
        if(cur_b[i] =='.'){
            cur_b[i] = (cur_s == 1)?'X':'O';
            if(cur_b[i] == board[i])
            Q.push({cur_b, !cur_s});
            cur_b[i]='.';
        }
    }

    }

    ans?printf("yes\n"):printf("no\n");

    }

}
