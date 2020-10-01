package com.qdw.Test3;

public class Test2 {
}
/*


#include<bits/stdc++.h>
using namespace std;
struct node
{
    int w,h;
};
bool cmp(node a,node b)
{
    if(a.w==b.w) return a.h<b.h;
    else return a.w<b.w;
}
int main()
{
    node a[6];
    int i;
    scanf("%d");
    while(~scanf("%d %d",&a[0].w,&a[0].h))
        {
            if(a[0].w>a[0].h) swap(a[0].w,a[0].h);
            for(i=1;i<6;i++)
                {
                    scanf("%d %d",&a[i].w,&a[i].h);
                    if(a[i].w>a[i].h) swap(a[i].w,a[i].h);
                }
            sort(a,a+6,cmp);
            int flag=0;
            for(i=0;i<6;i+=2)
                {
                    if(a[i].w!=a[i+1].w || a[i].h!=a[i+1].h)
                        {
                            flag = 1;
                            break;
                        }
                }
            if(!flag)
                {
                    if(a[0].w==a[2].w)
                        {
                            if((a[0].h==a[4].w && a[2].h==a[4].h) || (a[0].h==a[4].h && a[2].h==a[4].w))
                                {
                                    printf("POSSIBLE");
                                }
                            else printf("IMPOSSIBLE");
                        }
                    else printf("IMPOSSIBLE");
                }
            else printf("IMPOSSIBLE");
        }
    return 0;
}
 */
