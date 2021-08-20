// #include<iostream>
// #include<vector>

// using namespace std;

// void display(vector<vector<int>> &arr)
// {
//         int a= arr.size();
//         int b=arr[0].size();
//         for(int i=0;i<a;i++)
//             for(int j=0;j<b;j++)
//                 cout << arr[i][j]<< " ";
//         cout << endl;

// }
// void input (vector<vector<int>> &arr)
// {
//         int a= arr.size();
//         int b=arr[0].size();
//         for(int i=0;i<a;i++)
//             for(int j=0;j<b;j++)
//                 cin >> arr[i][j];
//         display(arr);
// }

// int main()
// {
//         int n,m;
//         cin >> n >> m;
//         vector<vector<int>> arr(n,vector<int> (m,0));
//         input (arr); 
// }
#include <bits/stdc++.h>

using namespace std; int main()
{ string a,b; cin>>a>>b;
int x=a.length(), y=b.length(); int lcs[x+1][y+1];

for (int i=0; i<=x; i++)
{
for (int j=0; j<=y; j++)
{
if (i == 0 || j == 0) lcs[i][j] = 0;

else if (a[i-1] == b[j-1])
lcs[i][j] = lcs[i-1][j-1] + 1;

else
lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
}
}
vector<char> v; int i=x,j=y; while(i>0&&j>0)
{
if (a[i-1]==b[j-1])
{
v.push_back(a[i-1]); i--;
j--;
}
else if (lcs[i-1][j] > lcs[i][j-1]) i--;
else
j--;
}
cout<<"The length of longest common subsequence is \n"<<lcs[x][y]<<endl; cout<<"The longest common subsequence is\n"; reverse(v.begin(),v.end());
for(auto it:v) cout<<it;
return 0;
}
