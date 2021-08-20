import java.util.Scanner;
public class lect03{
    public static Scanner scn = new Scanner(System.in);
    //in this friends pair problem what we gonna do is consider if ABCDE is there then a either could pair with b,c,d,e or its remain sinngle
    //so if A is is single the recursive all for b,c,d,e and if not the recusrcive call for cde * n-1 means == A could pair with anyone b,c,d,e
    // ab A kisi k sath bhi pair bna le lets suppose a,b toh jo ans aaega vo ac ka bhi same hoga ex = ab c d e, ab c de, ab cd e, ab ce d and same number 
    // cases with ac b d e , ac b de, and so on;  
    // toh ab n toh 5 h dp[3] = 4; dp[4] = dp[3] + dp[2]*3 = 4 + 2*3 = 10;

    public static int friendspair(int n,int[] dp){
        if(n<=1){
            return dp[n] = 1;     
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int single = friendspair(n-1,dp);
        int pair = friendspair(n-2,dp) * (n-1);

        return dp[n] = single + pair;
    }
    public static int friendspair(int N,int[] dp){
        for(int n=0;n<=N;n++){
        if(n<=1){
            dp[n] = 1;
            continue;
        }
        int single = dp[n-1];
        int pair = dp[n-2] * (n-1);

        dp[n] = single + pair;
        }
        return dp[N];
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        System.out.println(friendspair(n,dp));   
    }
}