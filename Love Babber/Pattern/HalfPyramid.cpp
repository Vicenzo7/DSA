#include<iostream>
using namespace std;
int main()
{
   int n;
    cout<<"enter number"<<endl;
    cin>>n;
    for(int row=0;row<n;row++)
    {
        //for each row ,print stars = row ka no.
        for(int col=0;col<=row;col++)
        {
            cout<<"*";
        }
        //after every row
        cout<<endl;
    }
}