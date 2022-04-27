#include<iostream>
using namespace std;
int main()
{
     int n=7,count =1;
     for(int rows=1;rows<=n;rows++)
    {
        for(int cols=1;cols<=rows;cols++)
        {
            cout<<count++ <<" ";
        }
        cout<<endl;
    }
    return 0;
}