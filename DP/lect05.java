import java.util.Arrays;
public class lect05{
    // public static int longestcommansubsequence(String str1, String str2){
    //     int N = str1.length();
    //     int M = str2.lenght();
    //     int[][] dp = new int[N+1][M+1];
    //     for(int n=0;n<=N;n++){
    //         for(int m = 0;m<=M;m++){
    //             if(n==0 || m==0){ // lengh = 0 pe koi bhi comman nahi hoga or dp jo h sting ki length pe base h pointer base nahi h
    //                 dp[n][m] = 0;
    //                 continue;
    //             }
    //             if(str.charAt(n-1)==str.charAt(m-1))   // starting from last character if character are equal the +1 bcoz previous value also added
    //                 dp[n][m] = dp[n-1][m-1] +1;
    //             else    
    //                dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);
    //         }            
    //     }
    //     return dp[N][M];
    // }
    //     public static int solution(String str1, String str2, int n, int m, int[][] dp){
//         if(n==0 || m==0)  return dp[n][m] = (n==0 ? m : n);
//         if(dp[n][m] != -1) return dp[n][m];
//         int insert = solution(str1,str2,n,m-1,dp);
//         int delete = solution(str1,str2,n-1,m,dp);
//         int replace = solution(str1,str2,n-1,m-1,dp);
        
//         if(str1.charAt(n-1) == str2.charAt(m-1))
//             return dp[n][m] = replace;
//         else
//             return dp[n][m] = Math.min(Math.min(replace,insert),delete) + 1;
        
//     }
    // public static int solution(String str1, String str2, int[] cost, int N, int M, int[][] dp){
    //     for(int n=0;n<=N;n++){
    //         for(int m=0;m<=M;m++){
    //             if(n==0 || m==0){  
    //                 dp[n][m] = (n==0 ? m * cost[0] : n * cost[2]);
    //                 continue;
    //             }
    //             int insert = dp[n][m-1];
    //             int delete = dp[n-1][m];
    //             int replace = dp[n-1][m-1];
    //             if(str1.charAt(n-1) == str2.charAt(m-1))
    //                 dp[n][m] = replace;
    //             else
    //                 dp[n][m] = Math.min(Math.min(replace +cost[1],insert + cost[0]),delete + cost[2]);
    //         }
    //     }
        
        
    //     return dp[N][M];
    // }
    
    // public static int minDistance(String word1, String word2,int[] cost) {
    //     int n = word1.length();
    //     int m = word2.length();
    //     int[][] dp = new int[n+1][m+1];
    //     for(int[] d : dp)
    //         Arrays.fill(d,-1);
    //     return solution(word1,word2,cost,n,m,dp);
    // }

    // minimum delete require to make a string palindrome
    // public static int deleterequire1(String str, int i, int j, int[][] dp){
    //     if(i>=j)
    //         return dp[i][j] = i==0 ? 1 : 0;
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
    //     if(str.charAt(i) == str.charAt(j))
    //         return dp[i][j] = deleterequire1(str,i+1,j-1,dp);
    //     else 
    //         return dp[i][j] = Math.min(deleterequire1(str,i+1,j,dp),deleterequire1(str,i,j-1,dp)) +1;
    // }
    // public static int deleterequire(String str){
    //     int i=0;
    //     int j = str.length();
    //     int[][] dp = new int[j][j];
    //     for(int[] d : dp)
    //         Arrays.fill(d,-1);
    //     return deleterequire1(str,i,j-1,dp);
    // }

    // #####**** lcss ko tree se socho

    // operation needed to make longest comman subsequence mtlb kitni ek string mey kata piti kre ki vo same ho jae
    // ans lcs nikal lo and m - lcs + n-lcs is answer mean agr abcd and bcde h toh lcs = 3 and m - 3 = 1 a ko delete kro and n-3 = 1 e ko insert krlo m mey
    public static int editvariationlcss(String str1, String str2){
        int N = str1.length();
        int M = str2.length();
         int[][] dp = new int[N+1][M+1];
         for(int n=0; n<=N;n++){
             for(int m=0;m<=M;m++){
                 if(n==0 || m==0){
                    dp[n][m] = 0;
                    continue;
                 }
                if(str1.charAt(n-1) == str2.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1] + 1; 
                }
                else    
                    dp[n][m] = Math.max(dp[n][m-1],dp[n-1][m]);
             }
         }
         int x = dp[N][M];
         return M - x + N - x;
    }

    public static void main(String[] args){
            String s = "a";
            String t = "bcde";
            int[] cost = {2,1,2};     // insert, replace, delete
            System.out.print(editvariationlcss(s,t));
    }
}