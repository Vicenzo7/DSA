#include<iostream>
using namespace std;
int main()
{

    // int i=5;

    // //reference variable
    // int &j=i;

    // cout << i << endl;
    // i++;
    // cout << j << endl;
    // j++;
    // cout << i << endl;



    // //dynamic array
    // int n;
    // cout<< "enter the value of n" << endl;
    // cin >> n;

    // int *arr = new int[n];

    // for (i = 0; i < n; i++)
    // {
    //     cin>> arr[i];
    // }

    // cout << "printing the array" << endl;
    // for (i = 0; i < n; i++)
    // {
    //    cout << arr[i];
    // }

    // delete []arr;


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