#include<iostream>
using namespace std;

bool isPresent(int arr[], int size,int k)
{
    for(int i=0;i<size;i++)
    {
        if(arr[i]==k)
        {
            return true;
        }
    }

    return false;

}

int main()
{
    int n;
    cout<<"enter the size of array"<<endl;;
    cin>>n;
     int arr[n];
     cout<<"Enter the array elements"<<endl;;
     for(int i=0;i<n;i++)
     {
         cin>>arr[i];
     }
     
     int k;
     cout<<"enter the element you want to search"<<endl;
     cin>>k;
     bool status=isPresent(arr,n,k);
     cout<<status;
    return 0;
}