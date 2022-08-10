 
#include<bits/stdc++.h>
 
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
//      up - down - right - left  - 1 - 2 - 3 - 4
int dx[]= {-1,1,0, 0};
int dy[]= { 0,0,1,-1};
char C[]= {'U','D','R','L'};
int tot=0;
int n,m,resx,resy;
int m_i,m_j,z_i,z_j;
char a[50][50];
int cnt=0;
char RES;
bool f=0;
void solve(int x,int y,char c,int t)
{
   if(f)return;
 
    for(int i=0; i<4; i++)
    {
       if(C[i] != c && c!='M') continue;
        int tx=dx[i]+x,
            ty=dy[i]+y;
        if(tx<0 || tx>=n || ty<0 || ty>=m)continue;
        char tc=a[tx][ty];
        if(tc =='Z' && (RES!='a' && t == tot+1)|| ( RES=='+' && t == tot+2))
        {
            f=1;
            printf("%d %d %c\n",resx+1,resy+1,RES);
            return;
        }
 
        if(tc=='.' )
        {
            if(cnt==1)continue;
 
            if(i==0) // UP
            {
                // use   |
                RES='|';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'U',t+1);
                RES='a';
                cnt--;
 
                // use +
                a[tx][ty]='+';
                RES='+';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'U',t+1);
                RES='a';
                cnt--;
                a[tx][ty]='.';
 
 
            // use block 1 from U to R
                RES='1';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'R',t+1);
                RES='a';
                cnt--;
 
            // use block 4 from U to L
                RES='4';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'L',t+1);
                RES='a';
                cnt--;
 
            }
 
            else if(i==1)  //D
            {
           // use | to Down
                cnt++;
                RES='|';
                resx=tx,resy=ty;
                solve(tx,ty,'D',t+1);
                RES='a';
                cnt--;
 
          //  use + to Down
                cnt++;
                a[tx][ty]='+';
                RES='+';
                resx=tx,resy=ty;
                solve(tx,ty,'D',t+1);
                RES='a';
                a[tx][ty]='.';
                cnt--;
        // use block2 from D to L
                RES='2';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'R',t+1);
                RES='a';
                cnt--;
 
      // use block3 from D to R
                RES='3';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'L',t+1);
                RES='a';
                cnt--;
            }
 
            else if(i==2) // R
            {
               // use - to right
                RES='-';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'R',t+1);
                RES='a';
                cnt--;
 
            // use + To right
                RES='+';
                a[tx][ty]='+';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'R',t+1);
                RES='a';
                cnt--;
               a[tx][ty]='.';
 
            // use block 3 from R to U
                RES='3';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'U',t+1);
                RES='a';
                cnt--;
            // use block 3 from R to D
                RES='4';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'D',t+1);
                RES='a';
                cnt--;
            }
 
            else if(i==3)
            {
           // use -  to left
                RES='-';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'L',t+1);
                RES='a';
                cnt--;
 
                // use + to left
                a[tx][ty]='+';
                RES='+';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'L',t+1);
                RES='a';
                cnt--;
                a[tx][ty]='.';
 
                // use block 1 from L to D
                RES='1';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'D',t+1);
                RES='a';
                cnt--;
 
                // use block 2 from L to U
                RES='2';
                resx=tx,resy=ty;
                cnt++;
                solve(tx,ty,'U',t+1);
                RES='a';
                cnt--;
            }
 
        }
 
        else
        {
            // up & down
            if(tc=='|')
            {
                if(i==0)
                    solve(tx,ty,'U',t+1);
                else if(i==1)
                      solve(tx,ty,'D',t+1);
 
            }
            // right & left
            else if(tc=='-' )
            {
                if(i==2)
                    solve(tx,ty,'R',t+1);
                else if(i==3)
                    solve(tx,ty,'L',t+1);
            }
 
            if(tc=='+')
            {
                if(i==0)
                    solve(tx,ty,'U',t+1);
                else if(i==1)
                    solve(tx,ty,'D',t+1);
                else if(i==2)
                    solve(tx,ty,'R',t+1);
                else
                    solve(tx,ty,'L',t+1);
            }
            // block 1
            else if(tc=='1')
            {
                if(i==3)
                    solve(tx,ty,'D',t+1);
                else if(i==0)
                    solve(tx,ty,'R',t+1);
            }
            // block 2
            else if(tc=='2')
            {
                if(i==3)
                    solve(tx,ty,'U',t+1);
                else if(i==1)
                    solve(tx,ty,'R',t+1);
            }
            // block 3
            else if(tc=='3')
            {
                if(i==2)
                    solve(tx,ty,'U',t+1);
                else if(i==1)
                    solve(tx,ty,'L',t+1);
            }
            // block 4
            else if(tc=='4')
            {
                if(i==2)
                    solve(tx,ty,'D',t+1);
                else if(i==0)
                    solve(tx,ty,'L',t+1);
            }
 
        }
 
    }
}
int main()
{
 
#ifndef ONLINE_JUDGE
    freopen("read.txt","r",stdin);
    //freopen("output.txt","w",stdout);
#endif
//PI1(20);
    SI2(n,m);
    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
        {
            scanf(" %c",&a[i][j]);
            if(a[i][j]=='M')m_i=i, m_j=j;
            else if(a[i][j]=='Z')z_i=i, z_j=j;
            else if(a[i][j] == '+')tot+=2;
            else if(a[i][j]!='.' && a[i][j]!='M' && a[i][j]!='Z') tot++;
        }
    //    PI1(tot);
    solve(m_i,m_j,'M',0);
 
}
