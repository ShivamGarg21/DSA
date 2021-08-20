#include<iostream>
#include<vector>

using namespace std;
void inverse(vector<int> &a,int m)
{
        vector<int> b(m,0);
        for(int i=0;i<m;i++)
            b[a[i]]=i;
        outpt(b);
        
}
void outpt(vector<int> &b)
{
         for(int i=0;i<b.size();i++) 
             cout << b[i];
}
int main()
{
        int n;
        cin>>n;
        vector<int> a(n,0);
        for(int i=0;i<n;i++)
            cin>>a[i];
        inverse(a,n);
        return 0;
}