public class lect03{
    public static int divideInKGroups(int n, int k, int[][] dp){
            if(k == 1 || n == k)
                return dp[n][k] = 1;

            if(dp[n][k] != -1)
                return dp[n][k];

            int selfSet = divideInKGroups(n - 1, k - 1, dp);
            int partOfAnotherSet = divideInKGroups(n - 1, k, dp) * k;

            return dp[n][k] = selfSet + partOfAnotherSet;
        }

        public static void divideInKGroups(){
            int n = 5, k = 3;
            int[][] dp = new int[n + 1][k + 1];
            for(int[] d : dp)
                Arrays.fill(d, -1);

            System.out.println(divideInKGroups(n, k, dp));
            display2D(dp);
        }

        public static void main(String[] args){
            divideInKGroups();
        }
}