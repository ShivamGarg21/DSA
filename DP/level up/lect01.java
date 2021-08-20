public class lect01{
    /*
        1.Faith
        2. Recursive Tree
        3. Recursive code
        4. Convert Recursion code into memorization
        5. observation
        6. Tabulation
        7. Optimization
    */
    public static int febo_memo(int n, int[] dp){
        if(n <= 1)
            return dp[n] = n;

        if(dp[n] != 0)
            return dp[n];
        
        int ans = febo_memo(n-1,dp) + febo_memo(n-2,dp);
        
        return dp[n] = ans;
    }

}