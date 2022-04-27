#include<iostream>
using namespace std;
int main()
{
    int  k;
    int n=5;
    for(int rows =1;rows<=n;rows++)
    {
        for(int col=1;col<=n-rows;col++)
        {
            cout<<" ";
        }
        for(int col=1;col<=rows;col++)
        {
            cout<<col;
           k=col;
        }
        k=k-1;
        while(k>0)
        {
            cout<<k;
            k--;
        }

        cout<<endl;
    }
    return 0;
}