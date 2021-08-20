#include<iostream>
#include<vector>
using namespace std;
int stocks(vector<int> &prices){
 int max=0,mini=0,maxi=0;
        for(int i=0;i<prices.size()-1;i++){
                if(prices[mini]>prices[i+1])
                    mini=i+1;
        }
        for(int i=0;i<prices.size()-1;i++){
                if(prices[maxi]<prices[i+1]){
                    maxi=i+1;
                }
        }
        
        if(maxi>mini){
            max=prices[maxi]-prices[mini];
        }
        else{
            for(int i=0;i<prices.size();i++){
                    for(int j=i+1;j<prices.size();j++){
                            if(prices[j]-prices[i]>max)
                                 max=prices[j]-prices[i];
                    }
            }
        }
        return max;
}
int main(){
        vector<int> prices={100,1000,2,990,6,5,0,3};
        cout << stocks(prices);
        return 0;
}