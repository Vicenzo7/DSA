#include<iostream>
using namespace std;
int main()
{
    int n=5,counter=9,print=1;
    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<=9;col++)
        {
            if(col==counter)
            {
                cout<<print;
            } 
            else
            {
                cout<<"* ";
            }
        }
        print++;
        counter--;
        cout<<endl;
    }
    return 0;
}