#include<iostream>
#include<vector>
using namespace std;
int sum(vector <int> & arr){
        int sum=0;
        for(int i=0;i<arr.size();i++)
            sum += arr[i];
        return sum;
}
int number_sub(vector <int> & s,vector <int> & a,vector <int> & b,int idx){
        if(idx == s.size()){
                if(sum(a)==sum(b))
                    return 1;
                return 0;
        }
        int count =0;
        a.push_back(s[idx]);
        count+=number_sub(s,a,b,idx+1);
        a.pop_back();
        b.push_back(s[idx]);
        count+=number_sub(s,a,b,idx+1);
        b.pop_back();
        return count;
}
int main(){
        int n;
        cin >> n;
        vector<int> s(n,0);
        vector<int> a(n,0);
        vector<int> b(n,0); 
        for(int i=0;i<n;i++){
            cin >> s[i];
        }
        cout << number_sub(s,a,b,0);
        return 0;
}

