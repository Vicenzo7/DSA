#include<iostream>
using namespace std;
int main()
{
    int n;
    cout<<"enter number"<<endl;
    cin>>n;
    // for(int row=n;row>=0;row--)
    // {
    //     //for each row ,print stars = row ka no.
    //     for(int col=0;col<=row;col++)
    //     {
    //         cout<<"* ";
    //     }
    //     //after every row
    //     cout<<endl;
    // }

    //OR

    for(int row=1;row<=n;row++)
    {
        //for each row ,print stars = row ka no.
        for(int col=1;col<= n-row+1;col++)
        {
            cout<<"* ";
        }
        //after every row
        cout<<endl;
    }


}