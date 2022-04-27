#include<iostream>
#include<math.h>
using namespace std;

long fact(int n)
{
    int ans=1;
    for(int i=n;i>=1;i--)
    {
        ans=ans*i;
    }
    return ans;
}
long nCr(int rows,int col)
{
    int nr=rows-col;
    int val =fact(rows)/ (fact(nr)*fact(col));
}
int main()
{
    int n=5;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<=i;j++)
        {
            int val=nCr(i,j);
            cout<<val<<" ";
        }
        cout<<endl;
    }
    return 0;
}