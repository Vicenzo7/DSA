#include<iostream>
using namespace std;
int main()
{
    int n=5,k;
    for (int row = 1; row <= 5; row++)
    {
        for(int col=1;col<= row;col++)
        {
            cout<<char(col+64)<<" ";
            k=col;
        }
        k=k-1;
        while(k>0)
        {
            cout<<char(k+64)<<" ";
            k--;
        }
        cout<<endl;
    }
    
    return 0;
}