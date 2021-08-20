public static int fibo_memo(int n, int[] dp){
    if(n<=1){
        return dp[n] = n;
    }

    if(dp[n]!=-1){
        return dp[n];
    }
    int ans = fibo_memo(n-1,dp) + fibo_memo(n-2, dp);
    return dp[n] = ans;
}

public static int fibo_dp(int N, int[] dp){
    for(int n=0; n<=N; n++){
        if(n<=1){
            dp[n] = n;
            continue;
        }
        dp[n] = dp[n-1]+dp[n-2];

    }

    return dp[N];
}

class Solution {
    public int minCostClimbingStairs_memo(int n, int[] cost, int[] dp){
        if(n<=1){
            dp[n] = cost[n];
            return dp[n];
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ans = Math.min(minCostClimbingStairs_memo(n-1,cost,dp),minCostClimbingStairs_memo(n-2,cost,dp));
        if(n<cost.length)
                ans += cost[n];
        return dp[n]=ans;
    }
    public int minCostClimbingStairs_dp(int N, int[] cost, int[] dp){
        int ans;
        for(int n=0;n<=N;n++){
            if(n<=1){
                dp[n] = cost[n];
                continue;
            }
            ans = Math.min(dp[n-1],dp[n-2]);
            if(n<N)
                ans += cost[n];
            dp[n]=ans;
        }
        return dp[N];
    }
    
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        int ans =minCostClimbingStairs_dp(cost.length,cost,dp);
        return ans;
    }
    
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        // dp[cost.length] = Math.min(minCostClimbingStairs_memo(cost.length-1,cost,dp),minCostClimbingStairs_memo(cost.length-2,cost,dp));
        int ans =minCostClimbingStairs_memo(cost.length,cost,dp);
        return ans;
    }
}

public static int fibo_opti(int n){
    int a = 0;
    int b=1;
    for(int i=0;i<n;i++){
        System.out.print(a+ "");
        a=b;
        int sum = a+b;
        b = sum;
    }
    

}