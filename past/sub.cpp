#include<iostream>
#include<vector>
using namespace std;
//  void subtract(int n, int m, int b)
//  {
//         int sub=0, borrow=0,res=0,pwr=1; 
//         while(n!=0)
//         {
//                 sub=n%10-m%10+borrow;
//                 n/=10;
//                 m/=10;
//                 if(sub>=0)
//                     borrow=0;
//                 else
//                 {
//                     sub+=b;
//                     borrow=-1;
//                 }
//                 res+=sub*pwr;
//                 pwr*=10;

//         }
//         cout << res << endl;
//  }
void sub(vector <int> &a, vector <int> &b)
        {
                int n1=a.size();
                int n2=b.size();
                int borrow=0;
                int x=max(n1,n2);
                n1--;
                n2--;
                vector<int> c(x,0);
                for(int i=0;i<x;i++)
                {
                    int sum = borrow;
                    if(n2-i>=0)
                        sum += b[n2-i];
                    if(n1-i>=0)
                        sum-=a[n1-i];
                    if(sum<0)
                    {
                            sum+=10;
                            borrow = -1;
                    }
                    else 
                    borrow = 0;

                    c[c.size()-1-i]=sum;
                }
                bool flag=false;
                for(int l=0;l<c.size();l++)
                {
                        if(!flag && c[l]==0)
                            continue;
                        flag = true;
                        cout << c[l] << endl;
                }

        }
//  void sub(vector <int> &a, vector <int> &b)
//         {
//                 int n1=a.size();
//                 int n2=b.size();
//                 int borrow=0;

//                 vector<int> c(n1,0);
//                 for(int i=0;i<n1;i++)
//                 {
//                     int sum=a[n1-1-i]-b[n2-1-i]+borrow;
//                     if(sum<0)
//                     {
//                             sum+=10;
//                             borrow = -1;
//                     }
//                     else 
//                     borrow = 0;

//                     c[c.size()-1-i]=sum;
//                 }
//                 bool flag=false;
//                 for(int l=0;l<c.size();l++)
//                 {
//                         if(!flag && c[l]==0)
//                             continue;
//                         flag = true;
//                         cout << c[l];
//                 }

//         }
        void input(vector<int> & arr)
        {
                for(int i=0;i<arr.size();i++)
                    cin >> arr[i];
        }
int main()
        {
                int n,m;
                 cin >> n;
                 vector <int> a(n,0);
                input(a);
                cin >> m;
                vector<int> b(m,0);
                input(b);
                sub(a,b);
        }