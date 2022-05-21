#include<iostream>
inline int func(int x, int y)
{
    return x*y;
}
using namespace std;
int main()
{
    int x=3;
    int y =2;

    if(x>y)
    {
        cout<< "x is bigger"<< endl;
    }
    else{
        cout<< "y is bigger"<< endl;
    }
    int ans =func(x,y);
    cout<< ans<< endl;
    return 0;
}