    #include<iostream>
    #include<cstdio>
    #include<cstring>
    #include<cmath>
    #include<algorithm>
    #include<vector>
     
    bool cmp( int a, int b ) 
    {
       return a > b;
    }
     
    #define MOD 1000000007
    #define LL long long int
     
    using namespace std;
     
    int main()
    {
            int t=1;
            scanf("%d",&t);
            while(t--)
            {
                    int n,m,max1=-1,max2=-1;
                    printf("\n");
                    scanf("%d%d",&n,&m);
                    int temp;
                    for(int i=0;i<n;i++)
                    {
                            scanf("%d",&temp);
                            if(temp>max1)
                                    max1=temp;
                    }
                    for(int i=0;i<m;i++)
                    {
                            scanf("%d",&temp);
                            if(temp>max2)
                                    max2=temp;
                    }
                    if(max1>=max2)
                            printf("Godzilla\n");
                    else
                            printf("MechaGodzilla\n");
            }
            return 0;
    } 
