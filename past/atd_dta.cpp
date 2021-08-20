#include <iostream>
using namespace std;

int atd(int n, int b)
{
        int res=0,ld,pwr=1;

        while(n!=0)
        {
                ld=n%10;
                n=n/10;

                res = res + ld*pwr;
                pwr*=b;
        }
        return res;
}
int dta(int n,int b)
    {
            int res=0,pwr=1;
            while(n!=0)
            {
                int rem=n%b;
                n=n/b;
                res += rem*pwr;
                pwr*=10;
            }
            return res;
    }

int main()
{
        int n,a,b;
        cin >> n >> a >> b;
        int ans1=atd(n,a);
        int ans2=dta(ans1,b);
        cout << ans2;
}