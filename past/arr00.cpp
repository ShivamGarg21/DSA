#include <iostream>
#include <vector>

using namespace std;

int min(vector <int> &arr)
{
        int minele= (int) 1e9;
        for(int ele : arr)
        {
                if(minele>ele)
                    minele=ele;
        }
        return minele;  
}
int main()
{
        int n;
        cin >> n;
        vector <int> arr(n,0);
        for(int i=0;i<n;i++)
                cin >> arr[i];
        cout << min(arr);
}