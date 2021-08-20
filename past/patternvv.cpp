#include<iostream>
using namespace std;

void pattern(int n){
        int sp=n,i=1,st=1;
        while(i<2*n){
                int sp1=sp;
                while(sp1>0){
                    cout<<" ";
                    sp1--;
                }
                int st1=1;
                while(st1<=j){
                    cout << "*\t";
                    st1++;
                }
                cout<<endl;
                if(i<n){
                        st++;
                        sp--;
                }
                else{
                        st--;
                        sp++;
                }

                i++;              
        }
}

int main(){
        int x ;
        cin >> x;
        pattern(x);
        return 0;
}