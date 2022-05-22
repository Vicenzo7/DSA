#include<iostream>
using namespace std;
int main()
{
     int n;
    cout << "enter rows "<< endl;
    cin>> n;
    int m;
    cout << "enter colums"<< endl;
    cin >> m;

     int **arr = new int *[n];
     for(int i = 0;i<n;i++)
     {
         arr[i] = new int [n];
     }

     //input 
     for (int i = 0; i < n; i++)
     {
        for (int j = 0; j < m ; j++)
        {
            cin >> arr[i][j];
        } 
         
     }

    // output
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m ; j++)
        {
            cout<< arr[i][j] << " ";
        }  
        cout<< endl;
     }
     

     //deleting

     for (int i = 0; i < n; i++)
     {
       delete []arr[i]; 
     }

     delete []arr;
    return 0;
}