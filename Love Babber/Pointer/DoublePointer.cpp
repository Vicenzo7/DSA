#include<iostream>
using namespace std;

void func1(int **q)
{
    q=q+1;
}
void func2(int **q)
{
    *q=*q+1;
}
void func3(int **q)
{
    **q=**q+1;
}

int main()
{
    int a = 5;
    int *p = &a;
    int **q = &p;

    // cout << &a << endl;
    // cout << a << endl;
    // // cout << *a << endl;

    // cout << '\n';
    // cout << &p << endl;
    // cout << p << endl;
    // cout << *p << endl;


    // cout << '\n';
    // cout << &q << endl;
    // cout << q << endl;
    // cout << *q << endl;
    // cout << **q << endl;

    // cout<< "All good" << endl; 

    cout << "before " << q << endl;
    cout << "before " << *q << endl;
    cout << "before " << **q << endl;

    func1(q);

    cout << "after " << q << endl;
    cout << "after " << *q << endl;
    cout << "after " << **q << endl;

    cout << "before " << q << endl;
    cout << "before " << *q << endl;
    cout << "before " << **q << endl;

    func2(q);

    cout << "after " << q << endl;
    cout << "after " << *q << endl;
    cout << "after " << **q << endl;

    cout << "before " << q << endl;
    cout << "before " << *q << endl;
    cout << "before " << **q << endl;

    func3(q);

    cout << "after " << q << endl;
    cout << "after " << *q << endl;
    cout << "after " << **q << endl;


    // int arr[] ={1,2,3};

    // cout<< arr << endl;
    // cout<< arr+1 << endl;//--> 4 bytes ahead

    // cout<< &arr << endl;
    // cout<< &arr+1 << endl;


    // char ch='a';
    // char *ptr = &ch;
    // ch++;
    // cout<< *ptr << endl;


//error
    // int a[] ={1,2,3,4};
    // int *p = a++;

    // cout<< *p << endl;



    return 0;
}