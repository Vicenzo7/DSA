#include<iostream>
#include<math.h>
using namespace std;
int main()
{
    int num=16;
    int n=0;
    bool flag =false;
    if(num<=0)
    {
         cout<< "false";
    }

    //second Approach
    //     int ans = (n & n-1);
    //     if(ans == 0)
    //     {
    //         return true;
    //     }
        
    //     return false;
    // }


   // First approach
    int count=0;
    while(num !=0)
    {
        if((num&1)==1)
        {
            count++;
        }
        num= num>>1;
    }

    if(count==1)
    {
        cout<<"true";
    }
    else{
        cout<<"false";
    }

    //Third approach
    // int i=0;
    // while(n<num)
    // {
    //     n= pow(2,i);
    //     if(n==num)
    //     {
    //         flag =true;
    //         break;
    //     }
    //     i++;
    // }

    // if(flag == true)
    // {
    //     cout<<"true";
    // }
    // else{
    //     cout<< "false";
    // }



    return 0;
}