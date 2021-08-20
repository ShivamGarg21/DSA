#include<iostream>
using namespace std;
int multiply(int a, int b)
{
    return a*b;
}
int add(int a, int b)
{
        return a+b;
}
int divide(int a, int b)
{
        return b/a;
}
int tableofn(int n)
{
    for(int i=1;i<=10;i++)
            cout << n << "X" << i << "=" << n*i << endl;
           // cout << to_string(n) + "X" + to_string(i) + "=" + to_string(n*i);
}
int tableuptom(int m)
{
        for (int i=1;i<=m;i++){
            tableofn(i);
            cout << endl;
        }
}
int oddeven(int n)
{
        int c=n/2;
        if (n == 2*c)
                cout << "even" << endl;
        else
        {
                cout << "odd" << endl;
        }
        
}
int population(int n)
{
        int c;
        for(int i=1;i<=n;i++)
        {
                cin >> c;
                oddeven(c);
        }
}

int main()
{
     //   int a=10,b=20;
     //   cout << multiply(a,b) << endl;
     //   cout << add(a,b) << endl;
     //   cout << divide(a,b) << endl;
     int n;
     cin >> n;
       population(n);
}