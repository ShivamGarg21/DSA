// #include<iostream>
// using namespace std;

// void pattern(int n)
// {       int j;
//         for(int i=1;i<=n;i++)
//         {
//             for(j=1;j<=n;j++)
//             {
//                     if(j+i==n/2+2 || i-j==n/2|| j-i == n/2 || i+j==n+(n+1)/2 && n>5 || i+j==8 && n==5)
//                     cout << "*\t";
//                     else
//                         cout << "\t";
//             }
//             cout << endl;
//         }
// }
// int main()
// {
//         int n;
//         cin >> n;
//         pattern(n);
//}
#include <iostream>
using namespace std;
void pattern(int n)
{
        int nsp = 2*(n-1)-1,nst=1,j;
        for(int i=1;i<=n;i++)
        {
                for(j=1;j<=nst;j++)
                {
                    cout<<j<<"\t";
                }
                j--;
                
                for(int k=1;k<=nsp;k++)
                    cout << "\t";
                if(i==n)
                    j--;
                while(j>=1)
                {
                    cout<<j<<"\t";
                    j--;
                }
                nsp=nsp-2;
                nst++;
            cout << endl;
        }
}
int main(){
    int n;
    cin >> n;
    pattern(n);
    return 0;
    //write your code here
    
}