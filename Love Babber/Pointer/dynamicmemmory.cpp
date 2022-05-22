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



    //dynamic array
    int n;
    cout<< "enter the value of n" << endl;
    cin >> n;

    int *arr = new int[n];
    cout << "enter the values" << endl;

    for (int i = 0; i < n; i++)
    {
        cin>> arr[i];
    }

    cout << "printing the array" << endl;
    for (int i = 0; i < n; i++)
    {
       cout << arr[i] << " " ;
    }

    delete []arr;


   
     

    return 0;
}