#include <iostream>
using namespace std;
int main()
{
    int i;
    int n,count=0;
    cout << "enter a number ";
    cin >> n;

   for(i=2;i<n;i++)
   {
       if(n%i==0)
       {
         count++;
       }

   }
   
   if(count >0)
   {
       cout<< "not prime" << endl;
   }
   else{
       cout<< "prime" << endl;
   }
}