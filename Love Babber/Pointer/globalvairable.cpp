#include<iostream>
using namespace std;
int score=0;
void func1()
{
    cout << score << endl;
    score++;
    cout << "function 1"<< endl;
}

void func2()
{
    cout << score << endl;
    score++;
    cout << "function 2"<< endl;
}


void func3()
{
    cout << score << endl;
    score++;
    cout << "function 3"<< endl;
}
int main()
{

    func1();
    func2();
    func3();
    return 0;
}