#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

string sod(string arr,int idx)
{
        if(idx==(int)arr.size()-1)
                return arr[idx];
        arr[idx] = arr[idx] + sod(arr,idx+1);
        return arr[idx];
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    string arr;
    int idx=0;
    cin >> arr;
    string n = sod(arr,idx);
    cout << n;
    return 0;
}