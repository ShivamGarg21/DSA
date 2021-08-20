import java.util.LinkedList;
public class lect02{
    public static int dice_memo(int n, int[] dp){
        if(n==0){
            return dp[n] = 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ways=0;
        for(int i=1;i<=6;i++){
            if(n-i>=0)
                ways += dice_memo(n-i,dp);
        }
        return dp[n] = ways;
    }
    public static int dice_dp(int N, int[] dp){
        for(int n=0;n<=N;n++){ 
            if(n==0){
                dp[n] = 1;
                continue;
            }
            int ways=0;
            for(int i=1;i<=6;i++){
                if(n-i>=0)
                    ways += dp[n-i];
                }
            dp[n] = ways;
        }
        return dp[10];
    }

    public static int dice_opti(int N){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(1);
        for(int n=2;n<=N;n++){
            if(n<=6)
            list.addLast(2*list.peekLast());
            else
                list.addLast(2*list.peekLast()-list.removeFirst());
        }
        return list.removeLast();
    }
    public static void print(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }
    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print(a);
        }

        System.out.println();
    }
    // public static int mazepath_memo(int sr,int sc,int dr, int dc,int[][] dp){
    //         if(sr==dr&&sc==dc){
    //             return dp[sr][sc]=1;
    //         }
    //         if(dp[sr][sc]!=0){
    //             return dp[sr][sc];
    //         }

    //         int ans = 0;
    //         if(sr+1<=dr){
    //             ans += mazepath_memo(sr+1,sc,dr,dc,dp);
    //         }
    //         if(sc+1<=dc){
    //             ans += mazepath_memo(sr,sc+1,dr,dc,dp);
    //         }
    //         if(sc+1<=dc&& sr+1<=dr){
    //             ans += mazepath_memo(sr+1,sc+1,dr,dc,dp);
    //         }
    //         return dp[sr][sc]=ans;
    // }
    public static int mazepath_memo(int sr,int sc,int dr, int dc,int[][] dp){
            if(sr==dr&&sc==dc){
                return dp[sr][sc]=1;
            }
            if(dp[sr][sc]!=0){
                return dp[sr][sc];
            }

            int ans = 0;
                for(int jump=1;sr+jump<=dr;jump++)
                    ans += mazepath_memo(sr+jump,sc,dr,dc,dp);
                for(int jump=1;sc+jump<=dr;jump++)
                    ans += mazepath_memo(sr,sc+jump,dr,dc,dp);
                for(int jump=1;sr+jump<=dr&& sc+jump<=dc;jump++)
                    ans += mazepath_memo(sr+jump,sc+jump,dr,dc,dp);
            return dp[sr][sc]=ans;
    }


    public static void main(String[] args){
        // int[] dp = new int[11];

        int[][] dp = new int[3][3];
        System.out.print(mazepath_memo(0,0,2,2,dp));
        print2D(dp);
    }
}