#include<iostream>
using namespace std;
int main()
{
    int n;
    cout<<"enter number"<<endl;
    cin>>n;

    for(int row=1;row<=n;row++)
    {
        //for each row

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
}