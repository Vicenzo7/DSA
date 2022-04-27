#include<iostream>
using namespace std;
int main()
{
    int n=4,count =3;
    for(int rows=1;rows<=n;rows++)
    {
        for(int cols=1;cols<=rows;cols++)
        {
            cout<<count;
        }
        count++;
        cout<<endl;
    }
    count=5;
    for(int rows=1;rows<=n-1;rows++)
    {
        for(int cols=1;cols<=n-rows;cols++)
        {
            cout<<count;
        }
        count--;
        cout<<endl;
    }
    return 0;
}