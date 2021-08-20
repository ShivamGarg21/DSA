#include<iostream>
using namespace std;
void tribo(string s)
{
    string n=s.substr(2);
    cout << n;
}
int main()
{
        string s;
        cin >> s;
        tribo(s);
}