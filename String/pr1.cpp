#include<iostream>
#include<vector>
#include<string>

using namespace std;
// bool ispalindrome(string str)
// {
//         bool s;
//         int si=0,ei=str.length()-1;
//         while(si<ei)
//         {
//                 if(str[si++]==str[ei--])
//                     s=true;
//                 else
//                     return false;
                
//         }
//         return s;

// }
string compression(string str)
        {
                string sb;
                sb+=str[0];
                int count =1;
                for(int i=1; i<=str.length();i++)
                {
                        while(i<str.length() && str[i]==str[i-1])
                        {
                                i++;
                                count++;
                        }   
                        if(count!=1) sb+=to_string(count);
                        count=1;
                        if(i<str.length())
                        sb+=str[i]; 
                }
                return sb;
        }
int main()
{
        string str;
        cin >> str;
        cout << compression(str);
}