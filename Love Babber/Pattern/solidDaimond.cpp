#include<iostream>
using namespace std;
int main()
{
    int n=5;
    for(int row=1;row <=n;row++)
    {
        //spaces
        for(int col =1;col<= n-row;col++)
        {
            cout<<" ";
        }
         //star
         for(int col =1;col<= row;col++)
        {
            cout<<"* ";
        }
        cout<<endl;
    }

    //reverse
    for(int row=2;row <=n;row++)
    {
        //spaces
        for(int col =1;col<=row-1;col++)
        {
            cout<<" ";
        }
         //star
         for(int col =1;col<=n-row+1;col++)
        {
            cout<<"* ";
        }
        cout<<endl;
    }
}