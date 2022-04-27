#include<iostream>
using namespace std;
void xyz(int arr[],int s)
{
    arr[0]=20;
    for (int i = 0; i < s; i++)
    {
        cout<< arr[i]<<" ";
    }
    cout<<endl;

}
int main()
{
    int arr[3] = {3,6,9};
    xyz(arr,3);
    for (int i = 0; i < 3; i++)
    {
        cout<< arr[i]<<" ";
    }
    
    return 0;
}

