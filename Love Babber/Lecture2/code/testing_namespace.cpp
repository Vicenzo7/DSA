#include <iostream>
using namespace std;

namespace foo // define a namespace named foo
{
    // This doSomething() belongs to namespace foo
    int doSomething(int x, int y)
    {
        return x + y;
    }
}

namespace goo // define a namespace named goo
{
    // This doSomething() belongs to namespace goo
    int doSomething(int x, int y)
    {
        return x - y;
    }
}

int main()
{
    cout << foo::doSomething(4, 3) << '\n'; // use the doSomething() that exists in namespace goo
    return 0;
}