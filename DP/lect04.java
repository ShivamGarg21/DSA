public class lect04{    
     public static int solution(String s, int i, int j, int[][] dp){
        if(i>=j){
            return i==j? 1 : 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = solution(s,i+1,j-1,dp) + 2;
        }
        else{
            return dp[i][j] = Math.max(solution(s,i+1,j,dp),solution(s,i,j-1,dp));
        }
                
    }
 public static int longestPalindromeSubseq_tab(String s, int I, int J, int[][] dp){
        int n = s.length();
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){
                if(i >= j){ 
                    dp[i][j] = (i == j)? 1: 0;
                    continue;
                }    
        
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                else dp[i][j] = dp[i + 1][j - 1] + 2;
            }
        }
        return dp[I][J];
    }
     public static String solution(String s){
        int n = s.length();
        String[][] dp = new String[n][n];
        for(String[] d : dp)
            Arrays.fill(d,"");
        for(int gap =0; gap<s.length();gap++){
            for(int i=0, j=gap; j<s.length(); i++, j++){
                if(i>=j){
                    dp[i][j] = i==j?s.charAt(i) + "": "";
                }
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = s.charAt(i) + dp[i+1][j-1] + s.charAt(j); 
                }
                else    
                    dp[i][j] = dp[i+1][j].length()>dp[i][j-1].length() ? dp[i+1][j] : dp[i][j-1];
            }
        }
    }
    public int longestPalindromeSubseq(String s) {
        int i=0,j=s.length();
        int[][] dp = new int[j][j];
        for(int[] d : dp)
                Arrays.fill(d,-1);
        return solution(s,i,j-1,dp);
    }
    public static int palindromesubstring_count(String str){
        int n = str.length();
        int count =0;
        int maxlen =0;
        int[][] dp = new int[n][n];
        for(int gap = 0; gap<n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap == 0){   // all value is 1 bcoz one is string is palindrome 
                    dp[i][j] = 1;
                }
                else if(gap == 1){
                    dp[i][j] = str.charAt(i)==str.charAt(j)? 2:0;
                }
                else if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]>0)
                    dp[i][j] = dp[i+1][j-1] + 2;

                if(dp[i][j]>maxlen)
                    maxlen = dp[i][j];
                
                if(dp[i][j] != 0)   // every dp value > 0 will make a new palindrome thats how function is set
                    count++;
            }
        }
        return count;
    }
    public static int longestpalindromesubstring_count(String str){
        int n = str.length();
        int count =0;
        int maxlen =0;
        int stri =0;
        int strj=0;
        int[][] dp = new int[n][n];
        for(int gap = 0; gap<n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap == 0){   // all value is 1 bcoz one is string is palindrome 
                    dp[i][j] = 1;
                }
                else if(gap == 1){
                    dp[i][j] = str.charAt(i)==str.charAt(j)? 2:0;
                }
                else if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]>0)
                    dp[i][j] = dp[i+1][j-1] + 2;

                if(dp[i][j]>maxlen){
                    maxlen = dp[i][j];
                    stri = i;
                    strj=j;
                }
                
                if(dp[i][j] != 0)   // every dp value > 0 will make a new palindrome thats how function is set
                    count++;
            }
        }
        return str.substring(stri,strj+1);
    }
}