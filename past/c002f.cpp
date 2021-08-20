#include<iostream>
using namespace std;

void printfibonaccci(int n)
{
        int a=0,b=1,c;
        for(int i=1;i<=n;i++)
        {
            if(i==1)
                 cout << "0" << endl;
            else if(i==2)
                cout << "1" << endl;
            else
            {
                 c=a+b;
                 a=b;
                 b=c;
                 cout << c << endl;
            }
        }
}
int main()
{
        int n;
        cin >> n;
        printfibonaccci(n);
}