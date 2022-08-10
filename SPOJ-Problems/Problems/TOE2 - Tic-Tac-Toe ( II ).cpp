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
012  345  678
...  ...  ...
*/

bool winning(string s)
{

    bool is_full=1;

    for(int i=0; i<9; i++)
        if(s[i]=='.')
        {
            is_full=0;
            break;
        }

    if(is_full) return 1;

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
            (s[2]!='.' && s[2]==s[4] && s[4]==s[6]) ) return 1;

    return 0;
}

void solve(set<string> &valid)
{
    string start=".........";
    queue< pair<string, bool> >Q;
    Q.push({start,1});
    valid.insert(start);
    while(!Q.empty())
    {
        string cur_b=Q.front().first;
        bool cur_s=Q.front().second;
        Q.pop();
        if(winning(cur_b)) continue;

        for(int i=0; i<9; i++)
        {
            if(cur_b[i] =='.')
            {
                string B=cur_b;
                B[i] = (cur_s == 1)?'X':'O';
                if(valid.find(B) == valid.end())
                {
                    Q.push({B, !cur_s});
                    valid.insert(B);
                }
            }
        }
    }
return ;
}

int main()
{

#ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
#endif
    set<string>valid;
    solve(valid);

    string t;
    while(true)
    {
        cin>>t;
        if(t=="end") break;

        if(valid.find(t) != valid.end() && winning(t) ) printf("valid\n");
        else  printf("invalid\n");
    }
}
