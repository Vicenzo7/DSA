#include <iostream>
using namespace std;
int main()
{
    int n = 4, count = 1;
    for (int row = 1; row <= n; row++)
    {
        for (int col = 1; col <= row; col++)
        {
            cout << count++;
            if(col<row)
            {
                cout<<"*";
            }
            
        }
        cout << endl;
    }
    // count=10;
    // for (int row = 1; row <= n; row++)
    // {
    //     for (int col = 1; col <= n-row+1; col++)
    //     {
    //         cout << count--;
    //         if(col<row)
    //         {
    //             cout<<"*";
    //         }
            
    //     }
    //     cout << endl;
    // }
    return 0;
}