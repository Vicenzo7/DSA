#include<iostream>
using namespace std;
int main()
{
    int num=5;
    int mask=0;
    int ans=0;

    while(mask< num)
    {
        //to create mask
        mask= (mask << 1) | 1;
        // mask = mask | 1; (or with 1)
    }
     ans =(~num) & mask;
    cout<<ans;
    
    
    return 0;
}