#include<iostream>
using namespace std;
int main()
{
    int n=5;
    for (int row = 1; row <=n; row++)
    {
        for ( int col=1 ; col <= n-row; col++)
        {
            cout<<" ";
        }
        if(row==1)
        {
            cout <<"*";
        }
        else{
            cout<<"*";
            for(int col=1;col<=row-1;col++)
            {
                cout<<"  ";
            }
            cout<< "*";
        }
        cout<<endl;
        
    }

    for (int row = 1; row <=n; row++)
    {
        for ( int col=1 ; col <= row-1; col++)
        {
            cout<<" ";
        }
        if(row==n)
        {
            cout <<"*";
        }
        else{
            cout<<"*";
            for(int col=1;col<=n-row;col++)
            {
                cout<<"  ";
            }
            cout<< "*";
        }
        cout<<endl;
        
    }
    
    return 0;
}