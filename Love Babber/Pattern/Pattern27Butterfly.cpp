#include<iostream>
using namespace std;
int main()
{
    int n=5;
    for(int row=1;row<=n;row++)
    {
        //for each row ,print stars = row ka no.
        for(int col=1;col<=row;col++)
        {
            cout<<"*";
        }
        //spaces
        for(int col=1;col<= n-row;col++)
        {
            cout<<" ";
        }
        //spaces
        for(int col=1;col<= n-row;col++)
        {
            cout<<" ";
        }

        //for star
         for(int col=1;col<=row ;col++)
        {
            cout<<"*";
        }
        cout<<endl;
    }

    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<= n-row+1;col++)
        {
            cout<<"*";
        }
         //spaces
        for(int col=1;col<=row-1;col++)
        {
            cout<<" ";
        }
        //spaces
        for(int col=1;col<=row-1;col++)
        {
            cout<<" ";
        }

        //for star
        for(int col=1;col<= n-row+1 ;col++)
        {
            cout<<"*";
        }
        cout<<endl;
    }



    return 0;
}