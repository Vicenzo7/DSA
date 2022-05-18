#include<iostream>
using namespace std;

void function(int *p)
{
    //p=p+1  suppose p has 100 it will be 
    //   5+1;
     *p=*p+1;
}
void dummy(int *arr , int n)
{
    cout<< sizeof(arr) << endl;
}


int main()
{
    // int a=5;
    // int *p =&a;

    // cout<< sizeof(p) <<endl;

    // cout<< a<<endl;
    // cout<< &a<<endl;
    // // cout<< *a<<endl;
    // cout << p << endl;
    // cout << &p << endl;
    // cout << *p << endl;

    // int a=5;
    // int *p = &a;

    // cout << "Before " << p <<  endl;
    // cout << "Before " << *p <<  endl;
    // function(p);
    // cout << "After " << p <<  endl;
    // cout << "After " << *p <<  endl;


    // int arr[] ={1,2,3,4,5};
    // cout << arr << endl;
    // cout<< *arr << endl;
    // cout << &arr[0] << endl;
    // cout << &arr << endl;



    //  cout<< *arr << endl;
    // cout<< *(arr+1) << endl;
    // cout<< *(arr+2) << endl;
    // cout<< *(arr+3) << endl;
    // cout<< *(arr+4) << endl;
    // int i=0;
    // cout<< i[arr] << endl;
    // cout<< *(i+arr) << endl;

    // dummy(arr,5);


    // see the difference 
    // int arr[] ={1,2,3,4,5};
    // int *p = arr;
    // cout<< p << endl;

    // char ch[5] = "abcd";
    // char *ptr = ch;
    // cout << ptr << endl;

    // char charac = 'B';
    // char * ctr =  &charac;
    // cout << ctr << endl;

// test 

//dangling pointer 
    // int *p1;
    // cout << p1 << endl;
    // cout << *p1 << endl;
    // cout << &p1 << endl;

// null pointer 
// segmentation fault 
    // int *p2=0;
    // cout << p2 << endl;
    // cout << *p2 << endl;
    // cout << &p2 << endl;



    // if(cout<<"babbar")
    // {
    //     cout << 0 << endl;
    // }
    // else{
    //     cout << 1 << endl;;
    // }


    // char sentence [] = "My name is babbar";
    // char *p = sentence;
    // cout << p  << endl;
    // cout << *p << endl;
    // cout << &p << endl;







    return 0;
}