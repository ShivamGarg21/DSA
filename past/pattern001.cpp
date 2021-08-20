#include <iostream>
using namespace std;

void pattern(int n)
{
    int j;
    for (int i=1;i<=n;i++)
    {
        for (j=1;j<=n-i;j++)
        {
            //cout << "\t";
        }
        while(j<=n)
            {
                cout << "*\t"; 
                j++;
            }
            cout << endl;
    }
}
int main()
{
        int n;
        cin >> n;
        pattern(n);
}